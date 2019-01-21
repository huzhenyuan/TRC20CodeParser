package org.tron.smartcontract.tool;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CodeParserTool {

  private boolean name = false;
  private boolean symbol = false;
  private boolean decimals = false;
  private boolean totalSupply = false;
  private boolean balanceOf = false;
  private boolean transfer = false;
  private boolean transferFrom = false;
  private boolean approve = false;
  private boolean allowance = false;
  private boolean TransferEvent = false;
  private boolean ApprovalEvent = false;

  public void setName(boolean name) {
    this.name = name;
  }

  public void setSymbol(boolean symbol) {
    this.symbol = symbol;
  }

  public void setDecimals(boolean decimals) {
    this.decimals = decimals;
  }

  public void setTotalSupply(boolean totalSupply) {
    this.totalSupply = totalSupply;
  }

  public void setBalanceOf(boolean balanceOf) {
    this.balanceOf = balanceOf;
  }

  public void setTransfer(boolean transfer) {
    this.transfer = transfer;
  }

  public void setTransferFrom(boolean transferFrom) {
    this.transferFrom = transferFrom;
  }

  public void setApprove(boolean approve) {
    this.approve = approve;
  }

  public void setAllowance(boolean allowance) {
    this.allowance = allowance;
  }

  public void setTransferEvent(boolean transferEvent) {
    TransferEvent = transferEvent;
  }

  public void setApprovalEvent(boolean approvalEvent) {
    ApprovalEvent = approvalEvent;
  }

  @Override
  public String toString() {
    return "CodeParserTool{" +
        "name=" + name +
        ", symbol=" + symbol +
        ", decimals=" + decimals +
        ", totalSupply=" + totalSupply +
        ", balanceOf=" + balanceOf +
        ", transfer=" + transfer +
        ", transferFrom=" + transferFrom +
        ", approve=" + approve +
        ", allowance=" + allowance +
        ", TransferEvent=" + TransferEvent +
        ", ApprovalEvent=" + ApprovalEvent +
        '}';
  }

  /**
   * @return true: TRC20, false non-TRC20
   */
  public boolean parseTRC20(String expr) {
    CharStream in = CharStreams.fromString(expr);
    SolidityLexer lexer = new SolidityLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    SolidityParser parser = new SolidityParser(tokens);
    ParseTree tree = parser.sourceUnit();
    SolidityListener listener = new SolidityBaseListener(this);
    ParseTreeWalker.DEFAULT.walk(listener, tree);
    return name && symbol && decimals && totalSupply && balanceOf
        && transfer && transferFrom && allowance
        /* && approve && ApprovalEvent */
        && TransferEvent;
  }

}
