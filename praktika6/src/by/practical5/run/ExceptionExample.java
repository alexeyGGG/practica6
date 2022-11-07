package by.practical5.run;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExceptionExample {
    public static String fileName = "exampleFile.txt";
    public static String filePath =
            "/Users/olga/Documents/workspace/ADP/src/by/practical5/run/";
    public static void main(String[] args) {
// для получения ошибки раскомментируйте 6 строку

// triggerStackOverflowError();
        int[] intArray = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000
        };
/*
* RuntimeException – это непроверяемых(unchecked) исключения. Они
возникают во
* время выполнения приложения. К таким исключениям относится,
например,
* NullPointerException. Они не требуют обязательного заключения в
блок
* try-catch. Когда RuntimeException возникает, это свидетельствует
о
* ошибке, допущенной программистом (неинициализированный объект,
выход
* за пределы массива и т.д.). Поэтому данное исключение не нужно
* обрабатывать, а нужно исправлять ошибку в коде, чтобы исключение
* вновь не возникало.
*/
// Примеры непроверяемых исключений
// Деление на ноль приведет к ArithmeticException
// раскомментируйте строки 35 - 36 для того, чтобы получить
// ArithmeticException
// так как непроверяемых исключения не обязательно заключать
        // в try-catch
// блок,
// то при компиляции компилятор не выдаст ошибку
// double res1 = intArray[8] / 0;
// System.out.println("res1 = " + res1);
        try {
            double catchedRes1 = intArray[8] / 0;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
// внутри одного блока можно обрабатывать более одного исключения
        try {
            Double d = null;
            System.out.println(" d = " + d.toString()); // сгенерируется
// NullPointerException,
// т.к. d не
// проинициализирован
            double res2 = intArray[10] / 9; // сгенерируется
// ArrayIndexOutOfBoundsException,
// т.к. вышли за пределы массива
            System.out.println("res2 = " + res2);
        } catch (ArrayIndexOutOfBoundsException oobe) {
            System.out.println("Getting " + oobe.getMessage());
        } catch (NullPointerException npe) {

            npe.printStackTrace();
            System.out.println("Getting NullPointerException");
        }
// также несколько типов исключения можно обработать в одном catch блоке
        int intFirstArgument = 0;
        try {
            String firstArgument = args[1];
            System.out.println("First argument = " + firstArgument);
            intFirstArgument = Integer.parseInt(firstArgument);
            System.out.println("You've entered valid integer value " +
                    intFirstArgument);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Handling exception:" + e);
        }
        System.out.println("after cathing exception");
        double square = getSquare(2, 7);
        System.out.println(String.format("square = %f", square));
        System.out.println("after printing square");
// пример работы с потоками ввода/вывода
// запись строки в файл
        String textToFile = "Hello from file";
        boolean isFileUpdated = writeStringToFile(textToFile, fileName,
                filePath);
        System.out.println(String.format("file updated [%b] with text [%s]",
                isFileUpdated, textToFile));
// чтение из файла в строку
        System.out.println("file " + filePath + fileName + " content:" +
                readFromFile(fileName, filePath));
    }
    static void triggerStackOverflowError() {
        triggerStackOverflowError();
    }
    public static double getSquare(double height, double width) throws
            IllegalArgumentException {
        if (height < 0) {
            throw new IllegalArgumentException("height<0");
        } else if (width < 0) {
            throw new IllegalArgumentException("width<0");
        }
        return height * width;
    }
    public static boolean writeStringToFile(String textToFile, String
            pFileName, String pFilePath) {

        boolean fileUpdated = true;
        FileOutputStream fos = null;
        File file;
        try {
// необходимо задать полный путь к файлу
            file = new File(pFilePath + pFileName);
            fos = new FileOutputStream(file);
            /*
             * Необходимо проверить, существует ли файл. Если
             * файла нет -создаем новый
             */
            if (!file.exists()) {
                file.createNewFile();
            }
            /*
             * Объект String не может быть напрямую записан в
             * файл. Необходимо
             * преобразовать объект String в массив bytes
             */
            byte[] bytesArray = textToFile.getBytes();
            fos.write(bytesArray);
            fos.flush();
            System.out.println("File Written Successfully");
        } catch (IOException ioe) { // обработка проверяемых
// (checked) исключений
            fileUpdated = false;
            ioe.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the Stream");
            }
        }
        return fileUpdated;
    }
    public static String readFromFile(String pFileName, String pFilePath) {
        File file = new File(pFilePath + pFileName);
        FileInputStream fis = null;
        StringBuilder builder = new StringBuilder();
        try {
            fis = new FileInputStream(file);
            System.out.println("Размер файла (в байтах) : "
                    + fis.available());
            int iCh;

            while ((iCh = fis.read()) != -1) {
                char ch = (char) iCh;
                builder.append(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return builder.toString();
    }
}
