package es.uv.eu.mastermind.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 * @brief Modelo de la aplicación
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class MastermindModelo
{
    // Número de rondas a jugar
    private int rondas = 5;
    // Ronda actual
    private int rondaActual = 0;
    
    // Colores elegidos por el J1
    private Color[] solucion = {Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY};
    // Colores elegidos por el J2
    private Color[] intento = {Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY};
    // Códigos de las pistas
    private int[] pistas = new int[4];
    
    // Todos los colores y sus nombres
    private String[] nombresColores = {"Negro", "Naranja", "Rosa", "Amarillo", "Blanco", "Rojo", "Azul", "Verde",};
    private Color[] colores = {Color.BLACK, Color.ORANGE, Color.PINK, Color.YELLOW, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN};
    
    // Quién juega? 1 = J1, 2 = J2
    private int jActivo;
    // Usuario
    private String usuario;
    // Vector del ranking
    private String[] ranking;
    // Vector de puntos
    private int[] puntosRank = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    // Paso
    private int paso;
    
    // Puntos
    int puntos = 0;
    
    // Imagen
    private BufferedImage imagen;
    private String imagenFileName = "";
    
    /**
     * @brief Constructor del modelo
     */
    public MastermindModelo()
    {
        jActivo = 1;
        paso = 0;
        ranking = new String[10];
    }
    
    /**
     * @brief Asigna un valor a las rondas
     * @param n Nuevo valor
     */
    public void setRondas(int n)
    {
        rondas = n;
    }
    
    /**
     * @brief Devuelve el número de rondas totales
     * @return Rondas
     */
    public int getRondas()
    {
        return rondas;
    }
    
    /**
     * @brief Aumenta la ronda si es posible
     * @param pistas Si toca mostrar las pistas
     * @return Si se ha aumentado o no
     */
    public Boolean pasarRonda(Boolean pistas)
    {
        Boolean ok = true;
        
        if ((rondaActual < (rondas - 1)) && (pistas))
            rondaActual++;
        else if (!pistas)
            ok = true;
        else
            ok = false;
        
        return ok;
    }
    
    /**
     * @brief Devuelve la ronda actual
     * @return Ronda actual
     */
    public int getRondaActual()
    {
        return rondaActual;
    }
    
    /**
     * @brief Asigna valores a la solucion
     * @param s Nombre del color a asignar
     */
    public void setSolucion(String s)
    {
        Boolean repe = false;
        
        for (int i = 0; (i < solucion.length) && (!repe); i++)
        {
            if (convertirColor(s) == solucion[i])
                repe = true;
        }
        
        if (!repe)  //Si no está repetido lo asignamos
        {
            solucion[paso] = convertirColor(s);
            paso++;
        }
        else
            System.out.println("Color repetido");
    }
    
    /**
     * @brief Devuelve el color de la solucion en la posicion i
     * @param i Posicion
     * @return Color
     */
    public Color getSolucion(int i)
    {
        return solucion[i];
    }
    
    /**
     * @brief Asigna un color al intento
     * @param s Nombre del color
     */
    public void setIntento(String s)
    {
        Boolean repe = false;
        
        for (int i = 0; (i < intento.length) && (!repe); i++)
        {
            if (convertirColor(s) == intento[i])
                repe = true;
        }
        
        if ((!repe) && (pistas[paso] != 2)) //Si no está repetido ni fijo
        {
            intento[paso] = convertirColor(s);
            
            paso++;
        }
        else if (pistas[paso] == 2) //Si está fijo
        {
            System.out.println("Color ya acertado");
            
            paso++;
        }
        else
            System.out.println("Color repetido");
    }
    
    /**
     * @brief Devuelve el intento en la posición i
     * @param i Posición
     * @return Color
     */
    public Color getIntento(int i)
    {
        return intento[i];
    }
    
    /**
     * @brief Asigna el jugador activo
     * @param i Jugador activo, 1 o 2
     */
    public void setJugador(int i)
    {
        jActivo = i;
    }
    
    /**
     * @brief Devuelve el jugador activo
     * @return Jugador activo
     */
    public int getJugador()
    {
        return jActivo;
    }
    
    /**
     * @brief Pone el paso a 0
     */
    public void resetPaso()
    {
        paso = 0;
    }
    
    /**
     * @brief Devuelve el paso actual
     * @return Paso
     */
    public int getPaso()
    {
        return paso;
    }
    
    /**
     * @brief Devuelve el vector de pistas
     * @return Vector pistas
     */
    public int[] getPistas()
    {
        return pistas;
    }
    
    /**
     * @brief Asigna un nombre al usuario
     * @param usuario Nombre
     */
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    /**
     * @brief Devuelve el usuario
     * @return Nombre
     */
    public String getUsuario()
    {
        return usuario;
    }
    
    /**
     * @brief Devuelve la imagen
     * @return Imagen
     */
    public BufferedImage getImagen()
    {
        return imagen;
    }

    /**
     * @brief Devuelve el nombre de la imagen
     * @return Nombre
     */
    public String getImagenFileName()
    {
        return imagenFileName;
    }
    
    /**
     * @brief Asigna una imagen segun un nombre
     * @param img Nombre
     */
    public void setImagen(String img)
    {
        try
        {
            imagenFileName = "imagenes/" + img + ".jpg";
            imagen = ImageIO.read(new File(imagenFileName));
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo '" + this.imagenFileName + "'.");
            System.out.println("Causa: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * @brief Devuelve el vector ranking (usuarios)
     * @return Vector Ranking
     */
    public String[] getRanking()
    {
        return ranking;
    }
    
    /**
     * @brief Inserta una entrada en el ranking en su puesto correspondiente
     */
    public void setRanking()
    {
        Boolean ok = false;
        
        ranking = Arrays.copyOf(ranking, ranking.length + 1);
        ranking[ranking.length - 1] = usuario;
        puntosRank = Arrays.copyOf(puntosRank, puntosRank.length + 1);
        puntosRank[puntosRank.length - 1] = puntos;
        
        quickSort(ranking, puntosRank, 0, (ranking.length - 1));
        
        ranking = Arrays.copyOf(ranking, ranking.length - 1);
        puntosRank = Arrays.copyOf(puntosRank, puntosRank.length - 1);
    }
    
    /**
     * @brief Devuelve el vector de puntos del ranking
     * @return Vector de puntos
     */
    public int[] getRankingPuntos()
    {
        return puntosRank;
    }
    
    /**
     * @brief Reinicia el intento del J2
     */
    public void resetIntento()
    {
        for (int i = 0; i < intento.length; i++)
        {
            if (pistas[i] != 2)
                intento[i] = Color.GRAY;
        }
    }
    
    /**
     * @brief Reinicia la solucion del J1
     */
    public void resetSolucion()
    {
        for (int i = 0; i < solucion.length; i++)
        {
            solucion[i] = Color.GRAY;
        }
    }
    
    /**
     * @brief Reinicia la ronda actual
     */
    public void resetRondas()
    {
        rondaActual = 0;
    }
    
    /**
     * @brief Reinicia el vector de pistas
     */
    public void resetPistas()
    {
        for (int i = 0; i < pistas.length; i++)
            pistas[i] = 0;
    }
    
    /**
     * @brief Convierte una string en el color correspondiente
     * @param command Nombre del color
     * @return Color
     */
    public Color convertirColor(String command)
    {
        Boolean ok = false;
        int i;
        
        for (i = 0; (i < nombresColores.length) && (!ok); i++)
        {
            if (nombresColores[i].equals(command))
                ok = true;
        }
        
        return colores[i - 1];
    }
    
    /**
     * @brief Comprueba el código del J2 y asigna las pistas
     */
    public void comprobarIntento()
    {
        Boolean ok;
        
        for (int i = 0; i < intento.length; i++)
        {
            ok = false;
            // Comprueba si está en la posición acertada
            if (intento[i] == solucion[i])
                pistas[i] = 2; //Todo correcto
            else
            {
                for (int j = 0; (j < solucion.length) && !ok; j++)
                    if (intento[i] == solucion[j])
                    {
                        pistas[i] = 1; //Color correcto
                        ok = true;
                    }
                    else
                        pistas[i] = 0; //Nada correcto
            }
        }
    }
    
    /**
     * @brief Calcula los puntos en función de los aciertos
     * @return Puntos
     */
    public int calculaPuntos()
    {
        puntos = 0;
        
        for (int i = 0; i < pistas.length; i++)
        {
            switch(pistas[i])
            {
                case 0:
                    puntos += 0; //Totalmente innecesario
                    break;
                case 1:
                    puntos += 15;
                    break;
                case 2:
                    puntos += 25;
                    break;
            }
        }
        
        return puntos;
    }
    
    /**
     * @brief Devuelve los puntos
     * @return Puntos
     */
    public int getPuntos()
    {
        return puntos;
    }
    
    /**
     * @brief Reinicia el juego entero
     */
    public void resetJuego()
    {
        resetPistas();
        resetIntento();
        resetSolucion();
        resetPaso();
        resetRondas();
    }
    
    /**
     * @brief Ordena el vector B en orden decreciente, y aplica el mismo orden a A
     *        mediante el algoritmo de QuickSort
     * @param A Vector de usuarios
     * @param B Vector de puntos
     * @param izq Límite izquierdo
     * @param der Límite derecho
     */
    public void quickSort(String[] A, int[] B, int izq, int der)
    {
        int pivote = B[izq];
        int i = izq;
        int j = der;
        int auxB;
        String auxA;
        
        while (i < j)
        {
            while ((B[i] >= pivote) && (i < j))
                i++;
            while (B[j] < pivote)
                j--;
            if (i < j)
            {
                auxB = B[i];
                auxA = A[i];
                
                B[i] = B[j];
                A[i] = A[j];
                
                B[j] = auxB;
                A[j] = auxA;
            }
        }
        
        A[izq] = A[j];
        B[izq] = B[j];
        
        if (izq < (j - 1))
            quickSort(A, B, izq, (j-1));
        if ((j + 1) < der)
            quickSort(A, B, (j+1), der);
    }
}
