# cucumber-spring

 public class TestingClass {

    public static void main(String[] args) {
        String A = "0051 0000 23586 2000";
        String B = "0051 0000 23586 2000";
        String C = "0051 0000 23686 2001";
        String AA = mismatchingSubString(A,C);
        String BB = mismatchingSubString(C,A);
        System.out.println(AA+" | "+BB);
    }


    public static String  mismatchingSubString(String A, String B) {

        List<String> original = Arrays.asList(A.split("( )"));
        Set<String> unique = new HashSet<String>(original);

        for(String regex : unique){
            if(!regexZ(regex,B)){
               A = A.replaceFirst(regex,"<font color=\"red\">"+regex+"</font>");
            }

        }
        return A;
    }

    public static boolean regexZ(String regex, String string){
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(string);
        while(mat.find()){
            if(mat.group().length()!=0){
                return true;
            }
        }
        return false;
    }
}


return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
