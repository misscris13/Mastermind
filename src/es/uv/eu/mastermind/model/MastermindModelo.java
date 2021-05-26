package es.uv.eu.mastermind.model;

import java.awt.Color;

/**
 * @brief Modelo de la aplicación
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class MastermindModelo
{
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
    
    // Paso
    private int paso;
    
    public MastermindModelo()
    {
        jActivo = 1;
        paso = 0;
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
        
        if (!repe)
        {
            intento[paso] = convertirColor(s);
            paso++;
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
    
    /*public void resetIntento()
    {
        for (int i = 0; i < intento.length; i++)
        {
            
        }
    }*/
    
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
        int puntos = 0;
        
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
}
