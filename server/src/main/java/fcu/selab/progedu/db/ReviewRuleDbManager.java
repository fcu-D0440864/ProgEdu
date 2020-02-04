package fcu.selab.progedu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fcu.selab.progedu.utils.ExceptionUtil;

public class ReviewRuleDbManager {
  private static ReviewRuleDbManager dbManager = new ReviewRuleDbManager();

  public static ReviewRuleDbManager getInstance() {
    return dbManager;
  }

  private IDatabase database = new MySqlDatabase();

  private static final Logger LOGGER = LoggerFactory.getLogger(ReviewRuleDbManager.class);

  private ReviewRuleDbManager() {

  }

  /**
   * Get Review_Rule Id by description
   *
   * @param description description
   * @return Id Review_Rule Id
   */
  public int getRevRuleId(String description) {
    return 0;
  }

  /**
   * Get Review_Rule description by id
   *
   * @param id Review_Rule Id
   * @return description
   */
  public String getRevRuleDesc(int id) {
    return "";
  }

  /**
   * Get Review_Rule all descriptions
   *
   */
  public List<String> getRevRuleAllDesc() {
    List<String> lsDesc = new ArrayList<>();
    return lsDesc;
  }

}
