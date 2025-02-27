public class Complex {

    // Atributos
    private int real;
    private int img;

    // Constructor
    public Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    // Métodos

    // Suma de dos números complejos
    public Complex addition(Complex other) {
        int newReal = this.real + other.real;
        int newImg = this.img + other.img;
        return new Complex(newReal, newImg);
    }

    // Resta de dos números complejos
    public Complex subtraction(Complex other) {
        int newReal = this.real - other.real;
        int newImg = this.img - other.img;
        return new Complex(newReal, newImg);
    }

    // Multiplicación de dos números complejos
    public Complex multiplication(Complex other) {
        int newReal = this.real * other.real - this.img * other.img;
        int newImg = this.real * other.img + this.img * other.real;
        return new Complex(newReal, newImg);
    }

    // División de dos números complejos
    public Complex division(Complex other) {
        int denominator = other.real * other.real + other.img * other.img;
        int newReal = (this.real * other.real + this.img * other.img) / denominator;
        int newImg = (this.img * other.real - this.real * other.img) / denominator;
        return new Complex(newReal, newImg);
    }

    // Conjugado de un número complejo
    public Complex conjugate() {
        return new Complex(this.real, -this.img);
    }

    // Módulo de un número complejo
    public double module() {
        return Math.sqrt(this.real * this.real + this.img * this.img);
    }

    // Fase (argumento) de un número complejo
    public double phase() {
        return Math.atan2(this.img, this.real);
    }

    // Potencia de un número complejo
    public Complex power(int exponent) {
        double modulus = Math.pow(this.module(), exponent);
        double phase = this.phase() * exponent;
        int newReal = (int) (modulus * Math.cos(phase));
        int newImg = (int) (modulus * Math.sin(phase));
        return new Complex(newReal, newImg);
    }

    // Raíz cuadrada de un número complejo
    public Complex[] squareRoot() {
        double modulus = Math.sqrt(this.module());
        double phase = this.phase() / 2;
        Complex root1 = new Complex((int) (modulus * Math.cos(phase)), (int) (modulus * Math.sin(phase)));
        Complex root2 = new Complex((int) (modulus * Math.cos(phase + Math.PI)), (int) (modulus * Math.sin(phase + Math.PI)));
        return new Complex[]{root1, root2};
    }

    // Logaritmo de un número complejo
    public Complex logarithm() {
        double realPart = Math.log(this.module());
        double imgPart = this.phase();
        return new Complex((int) realPart, (int) imgPart);
    }

    // Representación en String del número complejo
    @Override
    public String toString() {
        return this.real + (this.img >= 0 ? "+" : "") + this.img + "i";
    }

    // Conversión de String a Complex
    public static Complex toComplex(String cpx) {
        String[] parts = cpx.split("(?=[+-])"); // Split on + or - (lookahead)
        int real = Integer.parseInt(parts[0]);
        int img = Integer.parseInt(parts[1].replace("i", ""));
        return new Complex(real, img);
    }

    // Método main para pruebas
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, 2);

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);

        System.out.println("Suma: " + c1.addition(c2));
        System.out.println("Resta: " + c1.subtraction(c2));
        System.out.println("Multiplicación: " + c1.multiplication(c2));
        System.out.println("División: " + c1.division(c2));
        System.out.println("Conjugado de c1: " + c1.conjugate());
        System.out.println("Módulo de c1: " + c1.module());
        System.out.println("Fase de c1: " + c1.phase());
        System.out.println("c1^2: " + c1.power(2));
        System.out.println("Raíces cuadradas de c1: " + c1.squareRoot()[0] + ", " + c1.squareRoot()[1]);
        System.out.println("Logaritmo de c1: " + c1.logarithm());

        Complex c3 = Complex.toComplex("5-6i");
        System.out.println("String a Complex: " + c3);
    }
}