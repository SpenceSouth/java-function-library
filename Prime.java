//Prime number class
/*
This class has two methods that accept an integer value.  The isPrime() method takes in an integer value and returns
true or false to indicate a prime number.  getNextPrime() returns a prime number greater than the integer given to it.
*/

public class Prime{

   public Prime(){
   
   }

   // Returns true if input is a prime number.
   public boolean isPrime(int number) {
      if (number == 2) { 
         return true; }
      if (number % 2 == 0) { 
         return false; }
       
      for (int i = 3; i * i <= number; i += 2) {
         if (number % i == 0) { 
            return false; }
      }
       
      return true;
   }
   
   // Returns a prime number that is greater than or equal to input.
   public int getNextPrime(int number) {
      for (int i = number; true; i++) {
         if (isPrime(i)) { 
            return i; }
      }
   }


}//End Class Prime