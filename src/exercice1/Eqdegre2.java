package exercice1;


class Eqdegre2  
{
    private double r1,r2,i1,i2,testa,testb; //Données membres privées de la classe : les parties 
    //réelles et imaginaires des 2 racines de l’équation
    public Eqdegre2(double a, double b, double c)
    {
	 System.out.println("Constructeur"); 
	 r1=r2=i1=i2=0; 
	 testa=a; 
	 testb=b; //initialisations des données membres
	 résoudre(a,b,c);    //lancement de la méthode résoudre si ce n’est pas fait 
	  //depuis le main
     }
    
     public void résoudre(double a, double b, double c)
     {
         double delta = b*b - 4*a*c ; 
         // eq de deg 1
         if(a==0) {
        	 r1=-c/b ; 
        	 r2=r1 ; 
         }
         else { //eq de deg 2
         if (delta>=0) { // reel
        	 r1 = (-b-Math.sqrt(delta))/(2*a) ; 
        	 r2 = (-b+Math.sqrt(delta))/(2*a) ; 
         				}
         else { // complexe
        	 r1 = -b/2*a ; 
        	 r2 = r1 ; 
        	 i1 = -(Math.sqrt(-delta))/(2*a) ; 
        	 i2 = (Math.sqrt(-delta))/(2*a) ; 
        	 
         } 
         }
         
         
      }
     public String toString()
     {
         if ((testa == 0) && (testb != 0)) {
             return String.format("\nEquation de degré 1 : une seule solution : %.2f\n", r1);
         }
         
         if ((testa == 0) && (testb == 0)) { 
             return "Pas de solutions";
         }

         // eq reelle
         if (i1 == 0 && i2 == 0) {
             return String.format("\nRacine 1 : %.2f\nRacine 2 : %.2f\n", r1, r2);
         }

         // Sinon, on affiche sous forme complexe avec 2 décimales
         return String.format("\nRacine 1 : %.2f + i(%.2f)\nRacine 2 : %.2f + i(%.2f)\n", r1, i1, r2, i2);
     }
}