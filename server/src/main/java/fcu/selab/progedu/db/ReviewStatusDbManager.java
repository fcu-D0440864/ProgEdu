package fcu.selab.progedu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fcu.selab.progedu.service.ReviewStatusEnum;
import fcu.selab.progedu.utils.ExceptionUtil;

public class ReviewStatusDbManager {
  private static ReviewStatusDbManager dbManager = new ReviewStatusDbManager();

  public static ReviewStatusDbManager getInstance() {
    return dbManager;
  }

  private IDatabase database = new MySqlDatabase();

  private static final Logger LOGGER = LoggerFactory.getLogger(ReviewStatusDbManager.class);

  private ReviewStatusDbManager() {

  }

  /**
   * Get Review_Status Id by status
   *
   * @param status status
   * @return id status Id
   */
  public int getRevStatusId(String status) {
    String sql = "SELECT id FROM Review_Status WHERE status = ?";
    int statusId = 0;
    try (Connection conn = database.getConnection();
        PreparedStatement preStmt = conn.prepareStatement(sql)) {
      preStmt.setString(1, status);
      try (ResultSet rs = preStmt.executeQuery();) {
        while (rs.next()) {
          statusId = rs.getInt("id");
        }
      }
    } catch (SQLException e) {
      LOGGER.debug(ExceptionUtil.getErrorInfoFromException(e));
      LOGGER.error(e.getMessage());
    }
    return statusId;
  }

  /**
   * Get Review_Status status by Id
   *
   * @param statusId Id
   * @return ReviewStatusEnum ReviewStatusEnum
   */
  public ReviewStatusEnum getRevStatusName(int statusId) {
    String sql = "SELECT status FROM Review_Status WHERE id = ?";
    String statusName = null;

    try (Connection conn = database.getConnection();
        PreparedStatement preStmt = conn.prepareStatement(sql)) {
      preStmt.setInt(1, statusId);
      try (ResultSet rs = preStmt.executeQuery();) {
        while (rs.next()) {
          statusName = rs.getString("status");
        }
      }
    } catch (SQLException e) {
      LOGGER.debug(ExceptionUtil.getErrorInfoFromException(e));
      LOGGER.error(e.getMessage());
    }
    ReviewStatusEnum statusEnum = ReviewStatusEnum.getStatus(statusName);
    return statusEnum;
  }

}
