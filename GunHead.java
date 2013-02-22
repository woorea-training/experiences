
public class GunHead {

	public static void main(String[] args) {

/**
 * CAUTION : remember this program 
 * is an ONLY_ONE_EXECUTION_BY_PERSON_BEFORE_GO_HELL_TYPE (OOEBPBGTHT) :
 * choose carefuly your last wishes ...
 *     		
 */
		   if (args.length==0){
			  System.out.println("Me pego el tiro sin mas ... PUMMM"); 
			  System.out.println(" ... y con mas razon desde el Eclipse ...");
			  
		   } else {
			   
			   System.out.println("Mis ultimas voluntades son : "); 
			   for (int i = 0;i<args.length;i++){
				   int cualvoluntad = i;
				   cualvoluntad++;
				   System.out.println(cualvoluntad + " : " + args[i]);
			   }
		       System.out.println("Y dicho esto, me pego el tiro ... PUMMM"); 
		   }
		
	}

}
