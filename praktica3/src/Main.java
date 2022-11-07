class NumberTest{

    public static void main(String[] args){

        int i = 0;

        short sh = 0;

        double d = 0;

        Integer kl = new Integer(55);

        Integer k2 = new Integer(100);

        Double dl = new Double(3.14);

        try{

            i = Integer.parselnt(args[0]);

            sh = Short.parseShort(args[0]);

            d = Double.parseDouble(args[1]);

            dl = new Double(args[1]);

            kl = new Integer(args[0]);

        }catch(Exception e){}

        double x = 1.0/0.0;

        System.out.println("i = " + i) ;

        System.outjprintln("sh - " + sh) ;

        System.out.println("d. = " + d) ;

        System.out.println("kl.intValue() = " + kl.intValue());

        System.out.println("dl.intValue() '= "'+ dl.intValuei));

        System.out.println("kl > k2? " + kl.compareTo(k2));

        System.out.println ("x = " + x);

        System.out.println("x isNaN? " + Double.isNaN(x));

        System.out.println("x islnfinite? " + Double.islnfinite(x));

        System.out.println("x == Infinity? " +

                (x == Double.POSITIVE_INFINITY) );

        System.out.println("d = " + Double.doubleToLongBits(d));

        System.out.println("i = " + Integer.toBinaryString(i));

        System.out.println("i = " + Integer.toHexString(i));

        System.out.println("i = " + Integer.toOctalString(i));

    }

}
