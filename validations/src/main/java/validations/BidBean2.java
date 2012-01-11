package validations;

import javax.faces.context.*;
import javax.faces.component.*;
import javax.faces.validator.*;
import javax.faces.application.*;
import javax.faces.bean.*;

@ManagedBean(name="bidBean2")
@SessionScoped
public class BidBean2 {
  private String userID;
  private String keyword;
  private Double bidAmount;
  private Integer bidDuration;

  public String getUserID() { return(userID); }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getKeyword() { return(keyword); }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public Double getBidAmount() { return(bidAmount); }

  public void setBidAmount(Double bidAmount) {
    this.bidAmount = bidAmount;
  }

  public Integer getBidDuration() { return(bidDuration); }

  public void setBidDuration(Integer bidDuration) {
    this.bidDuration = bidDuration;
  }

  public String doBid() {
    doBusinessLogicForValidData();
    return("show-bid2");
  }
  
  private void doBusinessLogicForValidData() {}

  public void validateBidAmount(FacesContext context,
                                UIComponent componentToValidate,
                                Object value)
      throws ValidatorException {
    double bidAmount = (Double)value;
    double previousHighestBid = currentHighestBid();
    if (bidAmount <= previousHighestBid) {
      FacesMessage message =
        new FacesMessage("Bid must be higher than current " +
                         "highest bid ($" +
                         previousHighestBid + ").");
      throw new ValidatorException(message);
    }
  }

  public double currentHighestBid() {
    return(0.23); // Get from database in real life
  }
}
