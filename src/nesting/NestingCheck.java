package nesting;

import java.util.Iterator;

public class NestingCheck {
    Statement statement;
    BracketCheck bracketCheck;
    public static BracketStack bracketStack;
    int lineAdd = 0;
    public NestingCheck(){
        statement = new Statement();
        bracketCheck = new BracketCheck();
        bracketStack = new BracketStack();
    }

    public void checkStatement(String st){
        statement.checkStatement(st);
    }

    public void checkBracket(String st){
        System.out.println(BracketCheck.oneLineLoop );
        if(BracketCheck.oneLineLoop == 1){
            //System.out.println("666666666666666666666666666666666666666666666666666666");
            BracketCheck.oneLineLoop = 0;
            lineAdd = 1;
        }
        if(st.contains("for") || st.contains("while") || st.contains("{") || st.contains("}")){
            bracketCheck.checkBrackets(st);
        }else{
            if(BracketCheck.noBracketStatus == 1){
                BracketCheck.addValue = 1;
                BracketCheck.noBracketStatus = 0;
                BracketCheck.lineList.add(new Line(st,NestingCheck.bracketStack.size()));
                NestingCheck.bracketStack.oneTimePop();
            }else{
                BracketCheck.lineList.add(new Line(st,NestingCheck.bracketStack.size()+BracketCheck.addValue));
            }


/*            for (int i = -1; (i = st.indexOf("}", i + 1)) != -1; i++) {
                bracketStack.pop();
                BracketCheck.bracketMap.put(i,"}");
                System.out.println(i);
            }*/
            BracketCheck.addValue = 0;
        }

            System.out.println(BracketCheck.lineList.get(BracketCheck.lineList.size()-1).toString());

       // System.out.println(st+"------Line value---------"+(Integer.valueOf(bracketStack.size())+lineAdd));
    }

}
