
public class Java1DArray_2 {
	public static boolean canWin(int leap, int[] game) {
        int furthestReach = 0;
        int lastIndex = game.length - 1;
        while(furthestReach < lastIndex-leap){
        	if(furthestReach+leap >= lastIndex || furthestReach+1 >= lastIndex) {
        		return true;
        	}
        	else if(game[furthestReach+leap] == 0 && furthestReach+leap<lastIndex){
                furthestReach += leap;
            } else if (game[furthestReach+1] == 0 && furthestReach+1<lastIndex){
                furthestReach +=1;
            } else if (game[furthestReach-1] == 0 && game[furthestReach] > 0){
                game[furthestReach] = 1;
                furthestReach -= 1;
            }
        }

    return furthestReach >= lastIndex;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
