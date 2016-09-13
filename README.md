# cucumber-spring

 public static void mismatchingSubString() {

        String A = "0051 0000 23586 2000";
        String B = "0051 0000 23586 2000";
        String C = "0051 0000 23686 2001";
        List<String> original = Arrays.asList(A.split("( )"));
        Set<String> unique = new HashSet<String>(original);

        for(String regex : unique){
            System.out.println(regex);
            if(!regexZ(regex,C)){
               A = A.replaceFirst(regex,"<font color=\"red\">"+regex+"</font>");
            }

        }
        System.out.println(A);
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
