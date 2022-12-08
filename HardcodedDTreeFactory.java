/**
 * @author Steven Bogaerts (starter code)
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HardcodedDTreeFactory {

    public static void main(String[] args) {
        HardcodedDTreeFactory factory = new HardcodedDTreeFactory();
        
        System.out.println("--------------------------");
        DTreeNode tree2 = factory.hardcode2PersonaTree();
        System.out.println("2-persona tree:\n" + tree2);
        
        System.out.println("--------------------------");
        DTreeNode tree4 = factory.hardcode4PersonaTree();
        System.out.println("4-persona tree:\n" + tree4);
        
        System.out.println("--------------------------");
        DTreeNode tree9 = factory.hardcode9PersonaTree();
        System.out.println("9-persona tree:\n" + tree9);
    }
    
    public DTreeNode hardcode2PersonaTree() {
        // Approach #1
        DTreeNode tie = new DTreeNode("tie", false);
        DTreeNode bear = new DTreeNode("Bear", true);
        DTreeNode tiger = new DTreeNode("Tiger", true);
        tie.setNodeForNo(bear);
        tie.setNodeForYes(tiger);
        
        /**
            Approach #2 is Better(concise)
        
        DTreeNode bear = new DTreeNode("Bear", true);
        DTreeNode tiger = new DTreeNode("Tiger", true);
        DTreeNode tie = new DTreeNode("tie", false, bear, tiger);
        
        **/
        
        return tie;
    }
    
    /***********************************************************************
     * Solution for step 7
     ***********************************************************************/
    public DTreeNode hardcode4PersonaTree() {
        
        DTreeNode clothes = new DTreeNode("Clothes",false);
        
        DTreeNode armup = new DTreeNode("ArmUp",false);
        DTreeNode dog = new DTreeNode("Dog",true);
        DTreeNode unicorn = new DTreeNode("Unicorn",true);
        
        clothes.setNodeForNo(armup);
        armup.setNodeForNo(dog);
        armup.setNodeForYes(unicorn);
        
        DTreeNode tie = new DTreeNode("Tie",false);
        DTreeNode bear = new DTreeNode("Bear",true);
        DTreeNode tiger = new DTreeNode("Tiger",true);
        
        //Approach 2(using constructor 1) makes the code more concise! Use Approach 2.
        /** 
           
            DTreeNode dog = new DTreeNode("Dog",true);
            DTreeNode unicorn = new DTreeNode("Unicorn",true);
            DTreeNode armup = new DTreeNode("ArmUp",false,dog,unicorn);
            
            DTreeNode bear = new DTreeNode("Bear",true);
            DTreeNode tiger = new DTreeNode("Tiger",true);
            DTreeNode tie = new DTreeNode("Tie",false,bear,tiger);
            
            DTreeNode clothes = new DTreeNode("Clothes",false,armup,tie);
           
           **/
        
        clothes.setNodeForYes(tie);
        tie.setNodeForNo(bear);
        tie.setNodeForYes(tiger);

        // Returning clothes because this is the root node.
        return clothes;
    }
    
    public DTreeNode hardcode9PersonaTree(){
    
        DTreeNode parrot = new DTreeNode("Parrot",true);
        DTreeNode dog = new DTreeNode("Dog",true);
        DTreeNode walks_NoR = new DTreeNode("Walks",false,parrot,dog);
        
        DTreeNode panda = new DTreeNode("Panda",true);
        DTreeNode eating = new DTreeNode("Eating",false,walks_NoR,panda);
        
        DTreeNode bear = new DTreeNode("Bear",true);
        DTreeNode tiger = new DTreeNode("Tiger",true);
        DTreeNode tie_NoR = new DTreeNode("Tie",false,bear,tiger);
        
        //Internal Node! after RoN
        DTreeNode clothes = new DTreeNode("Clothes",false,eating,tie_NoR);
        
        DTreeNode unicorn = new DTreeNode("Unicorn",true);
        DTreeNode lion = new DTreeNode("Lion",true);
        DTreeNode tie_YeR = new DTreeNode("Tie",false,unicorn,lion);
        
        DTreeNode shark = new DTreeNode("Shark",true);
        DTreeNode fox = new DTreeNode("Fox",true);
        DTreeNode walks_YeR = new DTreeNode("Walks",false,shark,fox);
        
        //Internal Node! after YeR
        DTreeNode belt = new DTreeNode("Belt",false,tie_YeR,walks_YeR);
        
        //Root node
        DTreeNode armup = new DTreeNode("ArmUp",false,clothes,belt);
           
        return armup;
    }
    
    /***********************************************************************
     * End of solution for step 7
     ***********************************************************************/
     
    /*
     When you print your hardcoded trees, you should get:
     
        --------------------------
        2-persona tree:
        tie?
        No tie:
            Bear
        Yes tie:
            Tiger
        --------------------------
        4-persona tree:
        clothes?
        No clothes:
            armUp?
            No armUp:
                Dog
            Yes armUp:
                Unicorn
        Yes clothes:
            tie?
            No tie:
                Bear
            Yes tie:
                Tiger
        --------------------------
        9-persona tree:
        armUp?
        No armUp:
            clothes?
            No clothes:
                eating?
                No eating:
                    walks?
                    No walks:
                        Parrot
                    Yes walks:
                        Dog
                Yes eating:
                    Panda
            Yes clothes:
                tie?
                No tie:
                    Bear
                Yes tie:
                    Tiger
        Yes armUp:
            belt?
            No belt:
                tie?
                No tie:
                    Unicorn
                Yes tie:
                    Lion
            Yes belt:
                walks?
                No walks:
                    Shark
                Yes walks:
                    Fox
     */
    
}
