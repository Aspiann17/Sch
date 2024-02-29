import java.util.Scanner;

// Debug
import java.util.Arrays;

class Util {
    public static String block = "========================================================";

    public static void view(String text, String[] list_menu) {
        System.out.printf("%s%n%s%n",block,text);
        System.out.println("|------------------------------------------------------|");
        for (int i = 0; i < list_menu.length; i++) {
            System.out.printf("| %d | %-48s |%n", i+1, list_menu[i]);
        } System.out.println(block);
    }

    public static String[] merge_array(String[]... array) {
        // System.out.println(Arrays.toString(array));
        String [] tmp = new String[100];
        
        for (String[] arr : array) {       
            
        }
        return array[0];
    }
}

class Input {
    static Scanner sc = new Scanner(System.in);

    public static int iint(String text) {
        while (true) {
            System.out.print(text);
            try {
                if (sc.hasNextInt()) {
                    return sc.nextInt();
                } else {
                    throw new java.util.InputMismatchException();
                }
            } catch (java.util.InputMismatchException e) {
                sc.next();
                System.out.println("Invalid input!!!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static double idouble(String text) {
        while (true) {
            System.out.print(text);
            try {
                if (sc.hasNextDouble()) {
                    return sc.nextDouble();
                } else {
                    throw new java.util.InputMismatchException();
                }
            } catch (java.util.InputMismatchException e) {
                sc.next();
                System.out.println("Invalid input!!!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyMath {

    public class Phytagoras {
        public static double c(double a, double b) {
            return Math.sqrt(
                Math.pow(a, 2) + Math.pow(b, 2)
            );
        }

        public static double b(double c, double a) {
            return Math.sqrt(
                Math.pow(c, 2) - Math.pow(a, 2)
            );
        }

        public static double a(double c, double b) {
            return Math.sqrt(
                Math.pow(c, 2) - Math.pow(b, 2)
            );
        }

        public static void main() {
            String text = "|                      Phytagoras                      |";
            double x, y;
            int inp;
            String[] lformula = {
                "c² = b² + a²",
                "b² = c² - a²",
                "a² = c² - b²"
            }; Util.view(text, lformula);

            while (true) {
                inp = Input.iint("Choose: ");
                if (inp > lformula.length) {
                    System.out.println("Invalid input!");
                    continue;
                } break;
            }

            x = Input.idouble(String.format(
                "Masukkan nilai %s: ", (inp == 2 || inp == 3) ? "c" : "b"
            ));
            y = Input.idouble(String.format(
                "Masukkan nilai %s: ", (inp == 1 || inp == 2) ? "a" : "b"
            ));

            System.out.printf(
                "%.02f² %s %.02f² = %.03f\n", x, (inp == 1) ? "+" : "-", y,
                switch (inp) {
                    case 1 -> Phytagoras.c(y, x);
                    case 2 -> Phytagoras.b(x, y);
                    case 3 -> Phytagoras.a(x, y);
                    default -> throw new IllegalArgumentException();
                }
            );
        }
    }

    public class Resistor {
        public static double pararell() {
            double out = 0;

            for (int i = 0; i < Input.iint("Number of resistors: "); i++) {

            }
            
            
            return .5d;
        }

        public static void main() {
            String text = "|                       Resistor                       |";
            String[] list = {
                "Pararell"
            }; Util.view(text, list);

        }
    }
}

class Main {
    // public static void view(String[] list_menu) {
    //     System.out.println("""
    //         ========================================================
    //         |                       Main Menu                      |
    //         ========================================================""");
    //     for (int i = 0; i < list_menu.length; i++) {
    //         System.out.printf("| %d | %-48s |%n", i+1, list_menu[i]);
    //     } System.out.println("========================================================");
    // }

    public static void menu() {
        String text = "|                       Main Menu                      |";
        String[] list =  {
            "Phytagoras",
            "Resistor"            
        }; Util.view(text, list);

        switch (Input.iint("Choose: ")) {
            case 1:
                MyMath.Phytagoras.main();
                break;

            case 2:
                MyMath.Resistor.main();
                break;
            
            case 0:
                break;

            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        try {

        String[] list =  {
            "Phytagoras",
            "Resistor"            
        };
        String[] ls = {
            "Kuro",
            "Shiro",
            "Ao",
            "Aka",
            "Midori"
        };

        System.out.println(Arrays.toString(Util.merge_array(
            list,ls
        )));
        

            


            
        } finally { Input.sc.close(); }
    }
}