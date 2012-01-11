package validations;

import javax.faces.application.*;
import javax.faces.bean.*;
import javax.faces.context.*;

@ManagedBean(name="bidBean1")
@SessionScoped
public class BidBean1 {
  private String userID = "";
  private String keyword = "";
  private String bidAmount;
  private double numericBidAmount = 0;
  private String bidDuration;
  private int numericBidDuration = 0;

  public String getUserID() { return(userID); }
  
  public void setUserID(String userID) {
    this.userID = userID.trim();
  }

  public String getKeyword() { return(keyword); }
  
  public void setKeyword(String keyword) {
    this.keyword = keyword.trim();
  }

  public String getBidAmount() { return(bidAmount); }

  public void setBidAmount(String bidAmount) {
    this.bidAmount = bidAmount;
    try {
      numericBidAmount = Double.parseDouble(bidAmount);
    } catch(NumberFormatException nfe) {}
  }

  public double getNumericBidAmount() {
    return(numericBidAmount);
  }

  public String getBidDuration() { return(bidDuration); }

  public void setBidDuration(String bidDuration) {
    this.bidDuration = bidDuration;
    try {
      numericBidDuration = Integer.parseInt(bidDuration);
    } catch(NumberFormatException nfe) {}
  }

  public int getNumericBidDuration() {
    return(numericBidDuration);
  }

  public String doBid() {
    FacesContext context = FacesContext.getCurrentInstance();
    if (getUserID().equals("")) {
      context.addMessage(null, 
          new FacesMessage("UserID required"));
    }
    if (getKeyword().equals("")) {
      context.addMessage(null, 
          new FacesMessage("Keyword required"));
    }
    if (getNumericBidAmount() <= 0.10) {
      context.addMessage(null, 
          new FacesMessage("Bid amount must be at least $0.10."));
    }
    if (getNumericBidDuration() < 15) {
      context.addMessage(null, 
          new FacesMessage("Duration must be at least 15 days."));
    }
    if (context.getMessageList().size() > 0) {
      return(null);
    } else {
      doBusinessLogicForValidData();
      return("show-bid1");
    }
  }
  
  private void doBusinessLogicForValidData() {}
}
