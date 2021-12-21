function Fibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    return Fibonacci(n - 1) + Fibonacci(n - 2);
}
var number = 3;
console.log(Fibonacci(number));
8
