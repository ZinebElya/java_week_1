

/*TODO: Create the same application "Challenge1"  but now with the object version of these data types.
    What is the difference?
 */

public class DataTypes2 {
    public static void main(String[] args) {
        Integer myInt = 1;
        Double myDouble = 2.123456;
        Float myFloat = 4.23f;
        Boolean myBoolean = true;
        Character myChar = 'Z';
        Byte myByte = 127;
        Short myShort = 32767;
        Long myLong = 9223372036854775807L;

        System.out.println("myInt: " + myInt);
        System.out.println("myDouble: " + myDouble);
        System.out.println("myFloat: " + myFloat);
        System.out.println("myBoolean: " + myBoolean);
        System.out.println("myChar: " + myChar);
        System.out.println("myByte: " + myByte);
        System.out.println("myShort: " + myShort);
        System.out.println("myLong: " + myLong);

    }
}

/*One advantage of using object wrapper classes is that they provide additional functionality and methods that can be
 useful in certain situations, such as converting between different data types or performing arithmetic operations.
 Additionally, object wrapper classes can be used in situations where objects are required,
 such as in collections or as method parameters. However, using object wrapper classes can also be less efficient
 in terms of memory usage and performance compared to using primitive data types directly.*/

