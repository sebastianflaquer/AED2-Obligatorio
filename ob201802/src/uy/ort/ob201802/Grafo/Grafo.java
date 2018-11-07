/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.ob201802.Grafo;

public class Grafo {

    private NodoGrafo[] vertices;
    private Arista[][] matAdy;

    
    private int tope;
    private int cantidad;
    
    //CONSTRUCTOR
    public Grafo(int tope) {
        this.tope = tope;
        // this.cantidad = 0; INNECESARIO

        this.vertices = new NodoGrafo[tope];
        this.matAdy = new Arista[tope][tope];
        for (int i = 0; i < tope; i++) {
            for (int j = i; j < tope; j++) {
                matAdy[i][j] = matAdy[j][i] = new Arista();
            }
        }
    }
    
    //GETTER AND SETTERS
    public NodoGrafo[] getVertices() {
        return vertices;
    }

    public void setVertices(NodoGrafo[] vertices) {
        this.vertices = vertices;
    }
    public Arista[][] getMatAdy() {
        return matAdy;
    }

    public void setMatAdy(Arista[][] matAdy) {
        this.matAdy = matAdy;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    //METODOS	
    private int posOcupada() {
        for (int i = 0; i < tope; i++)
            if (vertices[i] != null)
                    return i;
        return -1;
    }

    private int posLibre() {
        for (int i = 0; i < tope; i++)
            if (vertices[i] == null)
                    return i;
        return -1;
    }

    // Pre: !existeVertice(ver) && !esLleno()
    public void agregarVertice(NodoGrafo ver) {
        int pos = posLibre();
        vertices[pos] = ver;
        for (int i = 0; i < tope; i++) {
            if(matAdy[pos][i].getValor() != 0 || matAdy[i][pos].getValor() != 0){
                matAdy[pos][i].setExiste(true);
                matAdy[i][pos].setExiste(true);
            }
        }
        cantidad++;
    }
    
    // Pre: existeVertice(origen) && existeVertice(destino) &&
    // !existeArista(origen, destino)
    public void agregarArista(NodoGrafo origen, NodoGrafo destino, int peso) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        matAdy[posOrigen][posDestino].setExiste(true);
        //matAdy[posDestino][posOrigen].setExiste(true);
        matAdy[posOrigen][posDestino].setValor(peso);
        //matAdy[posDestino][posOrigen].setValor(peso);
    }
    
    //MODIFICAR PESO ARISTA
    public void modificarPesoArista(NodoGrafo origen, NodoGrafo destino, int peso) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        matAdy[posOrigen][posDestino].setValor(peso);
        //matAdy[posDestino][posOrigen].setValor(peso);
    }
    
    //SI ESTA LLENO
    public boolean esLleno() {
        return cantidad == tope;
    }

   
    //EXISTE VERTICE
    public boolean existeVertice(NodoGrafo ver) {
        return posVertice(ver) != -1;
    }
    
     //POSICION VERTICE
    private int posVertice(NodoGrafo ver) {
        for (int i = 0; i < tope; i++){
            if(vertices[i] != null){
                if(ver.getCoordX() == vertices[i].getCoordX() && ver.getCoordY() == vertices[i].getCoordY()){
                    return i;
                }
//                if(ver.equals(vertices[i])){
//                    return i;
//                }
            }
        }
        return -1;
    }
    
    //EXISTE VERTICE CORDENADAS
    public boolean existeVerticeCord(Double coordX, Double coordY) {
        return posVerticeCord(coordX, coordY) != -1;
    }
    
    private int posVerticeCord(Double coordX, Double coordY) {
        for (int i = 0; i < tope; i++)
            if ((coordX.equals(vertices[i].getCoordY())) &&  (coordY.equals(vertices[i].getCoordY()))){
                return i;
            }   
        return -1;
    }    
    
    public NodoGrafo existeVerticeCordenadas(Double coordXi, Double coordYi) {
        for(int i = 0; i < tope; i++){
            if(this.vertices[i]!=null){
                Double cordX = this.vertices[i].getCoordX();
                Double cordY = this.vertices[i].getCoordY();
                
                int resX = cordX.compareTo(coordXi);
                int resY = cordY.compareTo(coordYi);
                        
                //if((cordX == coordXi)&&(cordY == coordYi)){
                if( resX == 0 && resY == 0 ){
                    return this.vertices[i];
                }
            }
        }
        return null;
    }
    
    //EXISTE ARISTA
    public boolean existeArista(NodoGrafo origen, NodoGrafo destino) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        return matAdy[posOrigen][posDestino].isExiste();
    }
    
    

    // Pre: existeVertice(ver)
    public void borrarVertice(NodoGrafo ver) {
        int pos = posVertice(ver);

        vertices[pos] = null;

        for (int i = 0; i < tope; i++) {
            matAdy[pos][i].setExiste(false);
            matAdy[i][pos].setExiste(false);
        }
    }

    public void borrarArista(NodoGrafo origen, NodoGrafo destino) {
        int posOrigen = posVertice(origen);
        int posDestino = posVertice(destino);

        matAdy[posOrigen][posDestino].setExiste(false);
        matAdy[posDestino][posOrigen].setExiste(false);
    }
    
    
    
    
    
    
    
    
    
    
    ///////////////////////////////
    // DFS MODIFICADO
    public int ejecutaDFS(){
        boolean[] vis = new boolean[tope];
        int count = 0;            
        int pos = posOcupada();

        if(pos != -1){
            ejecutaDFSRec(pos, vis); 
        }

//        if(pos != -1){
//            for (int i = 0; i < tope; i++) {
//                if(!vis[i] && vertices[i] != null)
//                {
//                    ejecutaDFSRec(i, vis); 
//                    //DFSRec(i, vis);
//                }
//            }
//        }

        for (int i = 0; i < vis.length ; i++) {
            if(vis[i] == false){
                count++;
            }
        }

        return count;
    }
    private void ejecutaDFSRec(int pos, boolean[] vis) {
        //vis[pos] = true;

        //Canalera CanaleraActual = (Canalera) vertices[pos].obtener();                
        //System.out.println(CanaleraActual.getCIafiliado());
        for (int i = 1; i < tope; i++) {
            if(!vis[i] && matAdy[pos][i].isExiste()){
                if(this.vertices[pos].getTipo() == "NodoRed"){
                    vis[pos] = true;
                }
                ejecutaDFSRec(i, vis);
            }
        }
    }
    ///////////////////////////////
    // DFS MODIFICADO END
    
    
    ///////////////////////////////
    // DFS
    public void DFS(){
        boolean[] vis = new boolean[tope];
        int pos = posOcupada();
        if(pos != -1){
            for (int i = 0; i < tope; i++) {
                if(!vis[i] && vertices[i] != null){
                    DFSRec(i, vis);
                }
            }
        }
    }

    private void DFSRec(int pos, boolean[] vis) {
        System.out.println("Llamo");
        vis[pos] = true;
        System.out.println(vertices[pos]);
        for (int i = 0; i < tope; i++) {
            if(!vis[i] && matAdy[pos][i].isExiste())
            {
                DFSRec(i, vis);
            }
        }
    }


    ///////////////////////////////
    // BFS
    public void BFS(){
        boolean[] vis = new boolean[tope];
        int pos = posOcupada();
        if(pos != -1){
            for (int i = 0; i < tope; i++) {
                if(!vis[i] && vertices[i] != null)
                {
                    BFSRec(i, vis);
                }
            }
        }
    }

    private void BFSRec(int pos, boolean[] vis) {
        Cola<Integer> cola = new Cola<Integer>();
        vis[pos] = true;
        cola.encolar(pos);
        while(!cola.esVacia())
        {
            int posNueva = cola.desencolar();
            System.out.println(vertices[posNueva]);
            for (int i = 0; i < tope; i++) {
                if(!vis[i] && matAdy[posNueva][i].isExiste())
                {
                    vis[i] = true;
                    cola.encolar(i);
                }
            }
        }
    }
    
    ///////////////////////////////
    // 
    //Pre: !esVacio()
    public Grafo prim(){
		
        Grafo ret = new Grafo(tope);

        for (int i = 0; i < tope; i++) {
            if(vertices[i] != null)
            {
                ret.agregarVertice(vertices[i]);
            }
        }

        boolean[] vis = new boolean[tope];
        // for (int i = 0; i < tope; vis[i++]=false);

        vis[posOcupada()] = true;

        for (int k = 0; k < cantidad-1; k++) {

            int min = Integer.MAX_VALUE;
            int posOrigen = -1;
            int posDestino = -1;

            for (int i = 0; i < tope; i++) {
                if(vis[i])
                {
                    for (int j = 0; j < tope; j++) {
                        if(!vis[j] && matAdy[i][j].isExiste() && matAdy[i][j].getValor() < min)
                        {
                            min = matAdy[i][j].getValor();
                            posOrigen = i;
                            posDestino = j;
                        }
                    }
                }
            }

            ret.agregarArista(vertices[posOrigen], vertices[posDestino], min);
            vis[posDestino] = true;

        }

        return ret;
    }
	
    public int dijkstra(NodoGrafo origen, NodoGrafo destino) {
        int posO = posVertice(origen);
        int posD = posVertice(destino);

        // Etapa 1: Inicializo vectores
        int[] dist = new int[tope];
        int[] ant = new int[tope];
        boolean[] vis = new boolean[tope];
        
        //for (int i = 0; i < tope; ant[i] = -1,dist[i] = Integer.MAX_VALUE,i++);
        for (int i = 0; i < tope; i++){
            ant[i] = -1;
            dist[i] = Integer.MAX_VALUE;
        }
        
        dijkstraInterno(posO, dist, ant, vis);
        
        if(dist[posD] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[posD];
        }
    }

    private void dijkstraInterno(int posO, int[] dist, int[] ant, boolean[] vis) {
        // Etapa 2: Actualizo las distancias de los adyacentes del origen
        dist[posO] = 0;
        vis[posO] = true;

        for (int i = 0; i < tope; i++) {
            if(matAdy[posO][i].isExiste()) {
                dist[i] = matAdy[posO][i].getValor();
                ant[i] = posO;
            }
        }

        // Etapa 3: Proceso iterativo para actualizar distancias,
        //    actualizando aquellas aristas que marquen un mejor camino

        for (int k = 1; k < tope; k++) {
            // Elijo al próximo vertice, siendo éste el de menor distancia no visitada
            int posCand = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < tope; i++) {
                if(!vis[i] && dist[i]<min) {
                    min = dist[i];
                    posCand = i;
                }
            }

            // Si no hay candidato, no es conexo.
            if(posCand == -1){
                return;
            }   

            vis[posCand] = true;

            for (int i = 0; i < tope; i++) {
                if(!vis[i] && matAdy[posCand][i].isExiste()){
                    int sumaDist = dist[posCand] + matAdy[posCand][i].getValor();
                    if(sumaDist < dist[i]){
                        dist[i] = sumaDist;
                        ant[i] = posCand;						
                    }
                }
            }
        }
    }
}

