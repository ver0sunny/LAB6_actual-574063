package Common;

import Client.ClientConsole;
import Common.collectionInfo.Coordinates;
import Common.collectionInfo.FormOfEducation;
import Common.collectionInfo.Person;
import Common.collectionInfo.Semester;
import Common.exceptions.BreaksLimitRulesException;
import Common.exceptions.EmptyFieldException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputAndVerifier {
    private final long minY = -828;
    private final int minStudentsCount = 0;
    private final int minShouldBeExpelled = 0;
    private final Integer minHeight = 0;
    private final Integer minWeight = 0;
    private final int minPassportID = 10;

    private Scanner userInput;

    public InputAndVerifier(Scanner userInput) {
        this.userInput = userInput;
    }

    public String askName() {
        String name;
        while (true) {
            try {
                ClientConsole.println("Enter group name__ ");
                name = userInput.nextLine().trim();
                ClientConsole.println(name);
                if (name.equals("")) throw new EmptyFieldException();
                break;
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No name spotted");
            } catch (EmptyFieldException exception) {
                ClientConsole.printerror("No name has been entered. Try again");
            } catch (IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return name;
    }

    public String askAdminName() {
        String adminName = null;
        while (true) {
            try {
                ClientConsole.println("Enter admin name__ ");
                adminName = userInput.nextLine().trim();
                ClientConsole.println(adminName);
                if (adminName.equals("")) throw new EmptyFieldException();
                break;
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No name spotted");
            } catch (EmptyFieldException exception) {
                ClientConsole.printerror("No name has been entered. Try again");
            } catch (IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return adminName;
    }

    public Integer askAdminHeight() {
        Integer adminHeight;
        String strAdminHeight;
        while (true) {
            try {
                ClientConsole.println("Enter admin height_[>" + minHeight + "]_ ");
                strAdminHeight = userInput.nextLine().trim();
                adminHeight = Integer.parseInt(strAdminHeight);
                ClientConsole.println(adminHeight);
                if (adminHeight <= minHeight) throw new BreaksLimitRulesException();
                if (strAdminHeight.equals("")) throw new EmptyFieldException();
                break;
            } catch (BreaksLimitRulesException e) {
                ClientConsole.printerror("Height must be greater than " + minHeight);
            } catch (NumberFormatException exception) {
                ClientConsole.printerror("Height must be entered as a number");
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No height spotted");
            } catch (EmptyFieldException exception) {
                ClientConsole.printerror("No height has been entered. Try again");
            } catch (IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return adminHeight;
    }

    public Integer askAdminWeight() {
        Integer adminWeight;
        String strAdminWeight;
        while (true) {
            try {
                ClientConsole.println("Enter admin weight_[>" + minWeight + "]_ ");
                strAdminWeight = userInput.nextLine().trim();
                adminWeight = Integer.parseInt(strAdminWeight);
                ClientConsole.println(adminWeight);
                if (adminWeight <= minWeight) throw new BreaksLimitRulesException();
                if (strAdminWeight.equals("")) throw new EmptyFieldException();
                break;
            } catch (BreaksLimitRulesException e) {
                ClientConsole.printerror("Weight must be greater than " + minWeight);
            } catch (NumberFormatException exception) {
                ClientConsole.printerror("Weight must be entered as a number");
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No weight spotted");
            } catch (EmptyFieldException exception) {
                ClientConsole.printerror("No weight has been entered. Try again");
            } catch (IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return adminWeight;
    }

    public String askAdminPassportId() {
        String adminPassportId;
        while (true) {
            try {
                ClientConsole.println("Enter admin passport ID_[valid 10 digit number]_ ");
                adminPassportId = userInput.nextLine().trim();
                ClientConsole.println(adminPassportId);
                if (adminPassportId.length() < minPassportID) throw new BreaksLimitRulesException();
                if (adminPassportId.equals("")) throw new EmptyFieldException();
                break;
            } catch (BreaksLimitRulesException e) {
                ClientConsole.printerror("Passport ID must be longer than " + minPassportID + " digits");
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No Passport ID spotted");
            } catch (EmptyFieldException exception) {
                ClientConsole.printerror("No Passport ID has been entered. Try again");
            } catch (IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return adminPassportId;
    }

    public Person askAdminInfo() {
        String adminName = askAdminName();
        Integer adminHeight = askAdminHeight();
        Integer adminWeight = askAdminWeight();
        String adminPassportId = askAdminPassportId();
        return new Person(adminName, adminHeight, adminWeight, adminPassportId);
    }

    public float askX() {
        float x;
        String strX;
        while (true) {
            try {
                ClientConsole.println("Enter X-coordinate__ ");
                strX = userInput.nextLine().trim();
                x = Float.parseFloat(strX);
                if (strX.equals("")) throw new EmptyFieldException();
                break;
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No X-coordinate spotted");
            } catch (EmptyFieldException exception) {
                ClientConsole.printerror("No X-coordinate has been entered. Try again");
            } catch (NumberFormatException exception) {
                ClientConsole.printerror("X-coordinate must be entered as a number");
            } catch (NullPointerException | IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return x;
    }

    public long askY() {
        long y;
        String strY;
        while (true) {
            try {
                ClientConsole.println("Enter Y-coordinate_[> " + minY + "]_ ");
                strY = userInput.nextLine().trim();
                y = Long.parseLong(strY);
                if (y <= minY) throw new BreaksLimitRulesException();
                if (strY.equals("")) throw new EmptyFieldException();
                break;
            } catch (BreaksLimitRulesException e) {
                ClientConsole.printerror("Y-coordinate must be greater than " + minY);
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No Y-coordinate spotted");
            } catch (EmptyFieldException e) {
                ClientConsole.printerror("No Y-coordinate has been entered. Try again");
            } catch (NumberFormatException exception) {
                ClientConsole.printerror("Y-coordinate must be entered as a number");
            } catch (NullPointerException | IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return y;
    }

    public Coordinates askCoordinates() {
        float x;
        long y;
        x = askX();
        y = askY();
        return new Coordinates(x, y);
    }

    public int askStudentsCount() {
        int studentsCount;
        String strStudentsCount;
        while (true) {
            try {
                ClientConsole.println("Enter students count_[> " + minStudentsCount + "]_ ");
                strStudentsCount = userInput.nextLine().trim();
                studentsCount = Integer.parseInt(strStudentsCount);
                if (studentsCount <= minStudentsCount) throw new BreaksLimitRulesException();
                if (strStudentsCount.equals("")) throw new EmptyFieldException();
                break;
            } catch (BreaksLimitRulesException e) {
                ClientConsole.printerror("Students count must be greater than " + minStudentsCount);
            } catch (EmptyFieldException e) {
                ClientConsole.printerror("No Students count has been entered. Try again");
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No Students count spotted");
            } catch (NumberFormatException exception) {
                ClientConsole.printerror("Students count must be entered as a number");
            } catch (NullPointerException | IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return studentsCount;


    }

    public int askShouldBeExpelled() {
        int shouldBeExpelled;
        String strShouldBeExpelled;
        while (true) {
            try {
                ClientConsole.println("Enter how many students should be  expelled[> " + minShouldBeExpelled + "]_ ");
                strShouldBeExpelled = userInput.nextLine().trim();
                shouldBeExpelled = Integer.parseInt(strShouldBeExpelled);
                if (shouldBeExpelled <= minShouldBeExpelled) throw new BreaksLimitRulesException();
                if (strShouldBeExpelled.equals("")) throw new EmptyFieldException();
                break;
            } catch (BreaksLimitRulesException e) {
                ClientConsole.printerror("Number of 'should-be-expelled'-students must be greater than " + minShouldBeExpelled);
            } catch (EmptyFieldException e) {
                ClientConsole.printerror("No number has been entered. Try again");
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No 'should-be-expelled'-studdents spotted");
            } catch (NumberFormatException exception) {
                ClientConsole.printerror("Number of 'should-be-expelled'-students must be entered as a number");
            } catch (NullPointerException | IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return shouldBeExpelled;
    }

    public FormOfEducation askFormOfEducation() {
        FormOfEducation formOfEducation;
        String strFormOfEducation;
        while (true) {
            try {
                ClientConsole.println("Enter form of education__choose from [ " + FormOfEducation.listAll() + "]_ ");
                strFormOfEducation = userInput.nextLine().trim();
                formOfEducation = FormOfEducation.valueOf(strFormOfEducation.toUpperCase());
                if (strFormOfEducation.equals("")) throw new EmptyFieldException();
                break;
            } catch (EmptyFieldException e) {
                ClientConsole.printerror("No form of education has been entered. Try again");
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No 'form of education' spotted");
            } catch (IllegalArgumentException e) {
                ClientConsole.printerror("There is no such form of education");
            } catch (NullPointerException | IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return formOfEducation;
    }

    public Semester askSemester() {
        Semester semester;
        String strSemester;
        while (true) {
            try {
                ClientConsole.println("Enter semester [ " + Semester.listAll() + "]_ ");
                strSemester = userInput.nextLine().trim();
                semester = Semester.valueOf(strSemester.toUpperCase());
                if (strSemester.equals("")) throw new EmptyFieldException();
                break;
            } catch (EmptyFieldException e) {
                ClientConsole.printerror("No semester has been entered. Try again");
            } catch (NoSuchElementException exception) {
                ClientConsole.printerror("No 'semester' spotted");
            } catch (IllegalArgumentException e) {
                ClientConsole.printerror("There is no such semester");
            } catch (NullPointerException | IllegalStateException exception) {
                ClientConsole.printerror("Oups... Something went wrong");
                System.exit(0);
            }
        }
        return semester;
    }


}
