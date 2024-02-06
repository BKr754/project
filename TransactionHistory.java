/*


public String getTicker - Will store ticker of the Stock or CASH
public String getTransDate -Date when the transaction occurred
public String getTransType - Type of transaction BUY/SELL for stock, DEPOSIT/WITHDRAW for CASH
public double getQty - Quantity for the transaction
public double getCostBasis  - Cost Basis of stock. For CASH this will be 1.00
public void toPrint - Prints the transaction

 */
public class TransactionHistory {
    private String ticker; // Will store ticker of the Stock or CASH
    private String transDate; // Date when the transaction occurred
    private String transType; //Type of transaction BUY/SELL for stock, DEPOSIT/WITHDRAW for CASH
    private double qty;  //Quantity for the transaction
    private double costBasis; //Cost Basis of stock. For CASH this will be 1.00

    //All get functions
    public String getTicker (){
        return ticker;
    }
    public String getTransDate (){
        return transDate;
    }
    public String getTransType (){
        return transType;
    }
    public double getQty(){
        return qty;
    }
    public double getCostBasis(){
        return costBasis;
    }
    //All set functions
    private void setTicker(String inputTicker){
        ticker=inputTicker;
    }
    private void setTransDate(String inputDate){
        transDate=inputDate;
    }
    private void setQty(double inputQty){
        qty=inputQty;
    }
    private void setTransType(String inputTransType){
        transType=inputTransType;
    }
    private void setCostBasis(double inputCostBasis){
        costBasis=inputCostBasis;
    }

    public TransactionHistory(){
        //Set all defaults here
        setTicker("");
        setTransDate("");
        setTransType("");
        setQty(0);
        setCostBasis(-1);
    }
    public TransactionHistory(String inputTicker,String inputTransDate, String inputTransType, double inputQty, double inputCostBasis){
        setTicker(inputTicker);
        setTransDate(inputTransDate);
        setTransType(inputTransType);
        setQty(inputQty);
        setCostBasis(inputCostBasis);
    }
    //Print method for Transaction
    public String toPrint(){
        return (ticker + "\t" + transDate + "\t" + transType + "\t" + qty + "\t" + costBasis);
    }

    /*public static void main (String[] args){

    }*/
}