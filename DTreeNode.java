/**
 * @author Steven Bogaerts (starter code)
 */

public class DTreeNode {

    private String text;
    private boolean isAnswer;
    private DTreeNode nodeForNo;
    private DTreeNode nodeForYes;
    
    public DTreeNode(String text,boolean isAnswer,DTreeNode nodeForNo,DTreeNode nodeForYes){
        this.text = text; 
        this.isAnswer = isAnswer;
        this.nodeForNo = nodeForNo;
        this.nodeForYes = nodeForYes;
    }
    
    public DTreeNode(String text, boolean isAnswer){
        this.text = text;
        this.isAnswer = isAnswer;
        nodeForNo = null;
        nodeForYes = null;
    }
    
    public String getText() {
        return text;
    }
    
    public boolean getIsAnswer() {
        return isAnswer;
    }
    
    public DTreeNode getNodeForNo() {
    return nodeForNo;
    }
    
    public DTreeNode getNodeForYes() {
        return nodeForYes;
    }
    
    public void setNodeForNo(DTreeNode tempNode){
        nodeForNo = tempNode;
    }
    
    public void setNodeForYes(DTreeNode tempNode){
        nodeForYes = tempNode;
    } 
    
    
    /******************************************************************************
     * Given code
     ******************************************************************************/
        
    public double getAverageNumQuestions() {
        return getSumNumQuestions(0) / 9.0; // Assumes there are 9 personas
    }
    
    private int getSumNumQuestions(int numSoFar) {
        if (text.equals("unknown"))
            return 0;
        else if (isAnswer)
            return numSoFar;
        else
            // What??
            return nodeForNo.getSumNumQuestions(numSoFar+1) + nodeForYes.getSumNumQuestions(numSoFar+1);
    }
    
    public String toString() {
        return toStringRec(0);
    }
    
    /** protected(access modifier) new char[level]? */
    
    protected String toStringRec(int level) {
        String indent = new String(new char[level]).replace("\0", "    "); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java
        if (isAnswer)
            return indent + text;
        else {
            return indent + text + "?" + "\n" + indent + "No " + text + ":\n" + nodeForNo.toStringRec(level+1) 
                                       + "\n" + indent + "Yes " + text + ":\n" + nodeForYes.toStringRec(level+1);
        }
    }
    /***********************************************************************
     * End of given code
     ***********************************************************************/
    
}
