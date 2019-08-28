package nesting;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class BracketCheck {
    final String str1 = "for";
    final String str2 = "while";
    static int oneLineLoop;
    public static HashMap<Integer, String> loopWordMap = new HashMap<Integer, String>();
    public static HashMap<Integer, String> bracketMap = new HashMap<Integer, String>();
    public static List<Line> lineList = new ArrayList<Line>();


    int forCount = 0;
    int whileCount = 0;
    int count = 0;

    public void addValues(Map.Entry<Integer, String> firstLoopValue){
        if(firstLoopValue.getValue().equalsIgnoreCase("{") || firstLoopValue.getValue().equalsIgnoreCase("for") || firstLoopValue.getValue().equalsIgnoreCase("while")){
            NestingCheck.bracketStack.push(firstLoopValue.getValue());
        }else if(firstLoopValue.getValue().equalsIgnoreCase("}")){
            NestingCheck.bracketStack.pop();
        }
    }


    public void checkBrackets(String text) {
        loopWordMap.clear();
        //System.out.print(text);
        forCount = StringUtils.countMatches(text, str1);
        whileCount = StringUtils.countMatches(text, str2);
        count = forCount + whileCount;

            for (int i = -1; (i = text.indexOf(str1, i + 1)) != -1; i++) {
                loopWordMap.put(i,"for");
            }
            for (int i = -1; (i = text.indexOf(str2, i + 1)) != -1; i++) {
                loopWordMap.put(i,"while");
            }
            for (int i = -1; (i = text.indexOf("{", i + 1)) != -1; i++) {
                //NestingCheck.bracketStack.push(1);
                loopWordMap.put(i,"{");
            }
            for (int i = -1; (i = text.indexOf("}", i + 1)) != -1; i++) {
                //NestingCheck.bracketStack.pop();
                loopWordMap.put(i,"}");
            }

        //System.out.println(loopWordMap);

        Map<Integer, String> sortedLoopWordMap = new TreeMap<Integer, String>(loopWordMap);
        if(sortedLoopWordMap.size()>0) {
            Set set2 = sortedLoopWordMap.entrySet();
            Iterator iterator2 = set2.iterator();
            while (iterator2.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator2.next();
               // System.out.print(pair.getKey() + ": ");
               // System.out.println(pair.getValue());
            }

            //Map.Entry<Integer, String> first = ((TreeMap<Integer, String>) sortedLoopWordMap).firstEntry();
           // System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^"+first);

            Iterator it = sortedLoopWordMap.entrySet().iterator();
            it.hasNext();
            Map.Entry<Integer, String> firstLoopValue = (Map.Entry)it.next();

            addValues(firstLoopValue);
            for( int a = 1; a<sortedLoopWordMap.size();a++){

                Map.Entry<Integer, String> secondLoopValue = (Map.Entry)it.next();
                System.out.println(firstLoopValue+"::::::::::::::::"+secondLoopValue);

                if(firstLoopValue.getValue().equals("while")||firstLoopValue.getValue().equals("for")){
                    if(secondLoopValue.getValue().contains("while") || secondLoopValue.getValue().contains("for")){
                        System.out.println("*********************************");
                        System.out.println("PEEK"+NestingCheck.bracketStack.peek());
                    }else  if(secondLoopValue.getValue().contains("{")){
                        addValues(secondLoopValue);
                        System.out.print("*****************333333333333333333****************");
                        //System.out.println("PEEK"+NestingCheck.bracketStack.peek());
                        //NestingCheck.bracketStack.push(2);
                        //oneLineLoop = 1;

                    }
                }else{
                    addValues(secondLoopValue);
                }
                firstLoopValue = secondLoopValue;
            }
        }

        lineList.add(new Line(text,NestingCheck.bracketStack.size()));

    }
}
