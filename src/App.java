import java.util.LinkedList;

public class App {
    
    public static int c=0;
    public static void main(String[] args) throws Exception {
        int a=5;
        int b=5;
        int m[][]=new int[a][b];
        m[0][1]=-1;
        m[1][1]=-1;
        m[2][2]=-1;
        System.out.println("ALFIL ");
        movimientotorre(m, 0, 0, a-1, b-1,1);
        System.out.println("total de movimiento es de: " + c);
       
    }



    
    public static void movimientoalfil(int m[][],int i,int j,int i1,int j1,int salto){
        m[i][j]=salto;
        if(i==i1 && j==j1){
        mostrarmatriz(m);
        System.out.println();
        c++;
        }
        LinkedList<reglas> L1 = alfil(m,i,j); 
        while(!L1.isEmpty()){
        reglas R =elegirregla(L1,m,i1,j1);
        m[R.fil][R.colum]=salto;
        movimientoalfil(m,R.fil,R.colum,i1,j1,salto+1);
        m[R.fil][R.colum]=0;
        }
        }

        public static LinkedList<reglas> alfil(int m[][],
        int i, int j){
        LinkedList<reglas> L1 = new LinkedList();
        int k=1;
        while(verificar(m,i-k,j-k)) {L1.add(new reglas(i-k,j-k)); k=k+1;}
        k=1; while(verificar(m,i-k,j+k)) {L1.add(new reglas(i-k,j+k)); k=k+1;}
        k=1; while(verificar(m,i+k,j+k)) {L1.add(new reglas(i+k,j+k)); k=k+1;}
        k=1; while(verificar(m,i+k,j-k)) {L1.add(new reglas(i+k,j-k)); k=k+1;}
        return L1;
        }
    public static void movimiento_reina(int m[][],int i,int j,int i1,int j1,int salto){
        m[i][j]=salto;
        if(i==i1 && j==j1){
        mostrarmatriz(m);
        System.out.println();
        c++;
        }
        LinkedList<reglas> L1 = reina(m,i,j); 
        while(!L1.isEmpty()){
        reglas R =elegirregla(L1,m,i1,j1);
        m[R.fil][R.colum]=salto;
        movimiento_reina(m,R.fil,R.colum,i1,j1,salto+1);
        m[R.fil][R.colum]=0;
        }
        }
        

        public static LinkedList<reglas> reina(int m[][],
        int i, int j){
            LinkedList<reglas> L1 = new LinkedList();
            int k=1;
            while(verificar(m,i-k,j )){L1.add(new reglas(i-k,j ));k=k+1;}
            k=1;while(verificar(m,i-k,j+k)) {L1.add(new reglas(i-k,j+k)); k=k+1;}
            k=1;while(verificar(m,i ,j+k)){L1.add(new reglas(i ,j+k)); k=k+1;}
            k=1;while(verificar(m,i+k,j+k)) {L1.add(new reglas(i+k,j+k)); k=k+1;}
            k=1;while(verificar(m,i+k,j )){L1.add(new reglas(i+k,j )); k=k+1;} 
            k=1;while(verificar(m,i+k,j-k)) {L1.add(new reglas(i+k,j-k)); k=k+1;}
            k=1;while(verificar(m,i ,j-k)){L1.add(new reglas(i,j-k));k=k+1;}
            k=1;while(verificar(m,i-k,j-k)) {L1.add(new reglas(i-k,j-k)); k=k+1;}                  
            return L1;
        }
       
        
    public static void movimientotorre(int m[][],int i,int j,int i1,int j1,int salto){
        m[i][j]=salto;
        if(i==i1 && j==j1){
        mostrarmatriz(m);
        System.out.println();
        c++;
        }
        LinkedList<reglas> L1 = torre(m,i,j); 
        while(!L1.isEmpty()){
        reglas R =elegirregla(L1,m,i1,j1);
        m[R.fil][R.colum]=salto;
        movimientotorre(m,R.fil,R.colum,i1,j1,salto+1);
        m[R.fil][R.colum]=0;
        }
        }
        public static LinkedList<reglas> torre(int m[][],
        int i, int j){
        LinkedList<reglas> L1 = new LinkedList();
        int k=1;
        while(verificar(m,i ,j-k)){L1.add(new reglas(i,j-k));k=k+1;}
        k=1;while(verificar(m,i-k,j )){L1.add(new reglas(i-k,j ));k=k+1;}
        k=1;while(verificar(m,i ,j+k)){L1.add(new reglas(i ,j+k));k=k+1;}
        k=1;while(verificar(m,i+k,j )){L1.add(new reglas(i+k,j ));k=k+1;}                      
        return L1;
        }
    
       
        
                
          

            
        

          	public static reglas elegirregla(LinkedList<reglas> L1,int m[][],int i ,int j){
                	return L1.removeFirst();
        	}
            public static reglas elegirreglaB(LinkedList<reglas> L1,int m[][],int i ,int j){
                 return L1.remove(L1.size()/4);
            }
                	
                	public static boolean verificar(int m[][],int i ,int j){
                	boolean t;
                	t=false;
                	if( i>=0  && j>=0 ){
                	if(i<m.length &&j<m[i].length && m[i][j]==0){
                	t=true;
                	}
                	}
                	return t;
                	}
                	public static void mostrarmatriz(int m[][]){
                	for(int i=0;i<m.length;i++){
                	for(int j=0;j<m[i].length;j++){
            	System.out.print(m[i][j] + " ");
                	}
                	System.out.println(); 
                	}
                	}
    
                   public static reglas caminocorto(LinkedList<reglas> L1 ,int m[][],int i1 ,int j1)
                   {
                   int i=0, men=Integer.MAX_VALUE, posMen =0;
                   while( i<L1.size()){
                   int dist=distancia(L1.get(i).fil,L1.get(i).colum,i1,j1);
                   if(dist<men){
                   men=dist;
                   posMen=i;
                   }
                   	i++;
                   	}
                   	return L1.remove(posMen);
                   	}
                   	public static int distancia(int x1,int y1,int x2,int y2){
                   	return (int)Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
                   	}

                       public static boolean llena(int m[][]){
                           boolean t=false;
                        for(int i=0;i<m.length;i++){
                        for(int j=0;j<m[i].length;j++){
                           if(m[i][j]==0){
                            t=true;
                           }
                        }
                        }
                        return t;
                        }
                    
}
