package es.uv.eu.mastermind.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
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
    
    public MastermindModelo()
    {
        jActivo = 1;
        paso = 0;
        ranking = new String[10];
    }
    
    public void setRondas(int n)
    {
        rondas = n;
    }
    
    public int getRondas()
    {
        return rondas;
    }
    
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
    
    public int getRondaActual()
    {
        return rondaActual;
    }
    
    public void setSolucion(String s)
    {
        Boolean repe = false;
        for (int i = 0; (i < solucion.length) && (!repe); i++)
        {
            if (convertirColor(s) == solucion[i])
                repe = true;
        }
        
        if (!repe)
        {
            solucion[paso] = convertirColor(s);
            paso++;
        }
        else
            System.out.println("Color repetido");
    }
    
    public Color getSolucion(int i)
    {
        return solucion[i];
    }
    
    public void setIntento(String s)
    {
        Boolean repe = false;
        
        for (int i = 0; (i < intento.length) && (!repe); i++)
        {
            if (convertirColor(s) == intento[i])
                repe = true;
        }
        
        if ((!repe) && (pistas[paso] != 2))
        {
            intento[paso] = convertirColor(s);
            
            paso++;
            //aumentarPaso();
        }
        else if (pistas[paso] == 2)
        {
            System.out.println("Color ya acertado");
            
            paso++;
            //aumentarPaso();
        }
        else
            System.out.println("Color repetido");
    }
    
    public Color getIntento(int i)
    {
        return intento[i];
    }
    
    public void setJugador(int i)
    {
        jActivo = i;
    }
    
    public int getJugador()
    {
        return jActivo;
    }
    
    public void resetPaso()
    {
        paso = 0;
    }
    
    public int getPaso()
    {
        return paso;
    }
    
    public int[] getPistas()
    {
        return pistas;
    }
    
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public BufferedImage getImagen()
    {
        return imagen;
    }

    public String getImagenFileName()
    {
        return imagenFileName;
    }
    
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
    
    public String[] getRanking()
    {
        return ranking;
    }
    
    public void setRanking()
    {
        Boolean ok = false;
        
        String user = usuario, auxUsuario;
        int ptos = devuelvePuntos(), auxPuntos, i;
        
        for (i = 0; i < ranking.length; i++)
        {
            if (puntosRank[i] < ptos)
            {
                auxUsuario = ranking[i];
                auxPuntos = puntosRank[i];
                
                ranking[i] = user;
                puntosRank[i] = ptos;
                
                ok = true;
                
                user = auxUsuario;
                ptos = auxPuntos;
            }
        }
    }
    
    public int[] getRankingPuntos()
    {
        return puntosRank;
    }
    
    public void resetIntento()
    {
        for (int i = 0; i < intento.length; i++)
        {
            if (pistas[i] != 2)
                intento[i] = Color.GRAY;
        }
    }
    
    public void resetSolucion()
    {
        for (int i = 0; i < solucion.length; i++)
        {
            solucion[i] = Color.GRAY;
        }
    }
    
    public void resetRondas()
    {
        rondaActual = 0;
    }
    
    public void resetPistas()
    {
        for (int i = 0; i < pistas.length; i++)
            pistas[i] = 0;
    }
    
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
    
    public int devuelvePuntos()
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
    
    public void aumentarPaso()
    {
        Boolean ok = true;
        int i;
        
        if(rondaActual == 0)
            paso++;
        else
        {
            for(i = paso; (i < 4) && (ok); i++)
            {
                if (pistas[i] != 2)
                    ok = false;
            }
            if (i == (paso + 1))
                paso++;
            else
                paso = i;
        }
        
        
    }
    
    public void resetJuego()
    {
        resetPistas();
        resetIntento();
        resetSolucion();
        resetPaso();
        resetRondas();
    }
}
