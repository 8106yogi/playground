import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.TimeZone;

public class Test {

    public static void main(String []str){

        String cPlusVar="this_is_a_variable";
        String javaVar="ThisIsAVariable";

        System.out.println(converJavaVariableToCPlusVar(javaVar));
        System.out.println(convertCPlusVariableToJavaVar(cPlusVar));


        System.out.println(solution("aabbccda"));


    }

    public static String converJavaVariableToCPlusVar(String str){
        char [] ch =str.toCharArray();
        StringBuilder sb=new StringBuilder();

        for(char c:ch){
            if(Character.isUpperCase(c)){
                sb.append("_").append(String.valueOf(c).toLowerCase());
            }else{
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();

    }

    public static String convertCPlusVariableToJavaVar(String str){
        String [] arr=        str.split("_");
        StringBuilder sb=new StringBuilder();

        for(String s:arr){
            if(sb.toString().isEmpty()){
                sb.append(s);
            }else{
                sb.append(s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase());

            }


        }
        return sb.toString();
    }


    public static  String solution(String inputString) {
//        if(inputString==null||inputString.length()<1||inputString.length()>1000)
//            return "invalid string";

        char [] ch=inputString.toCharArray();
        char temp=ch[0];
        int count=1;
        StringBuilder s=new StringBuilder();

        for(int i=1;i<ch.length;i++){
            if(temp==ch[i]){
                count++;
            }else{
                s.append(count+""+temp);
                count=1;
                temp=ch[i];
            }

        }
        s.append(count+""+temp);
        return s.toString();
    }


}
