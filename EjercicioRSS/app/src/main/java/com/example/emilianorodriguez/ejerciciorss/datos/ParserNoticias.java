package com.example.emilianorodriguez.ejerciciorss.datos;

import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.util.Xml;

import com.example.emilianorodriguez.ejerciciorss.entities.Noticia;


public class ParserNoticias {

	public static final String ITEM = "item";
	public static final String TITLE = "title";
	public static final String LINK = "link";
	public static final String DESCRIPTION = "description";
	public static final String AUTHOR = "author";
	public static final String CATEGORY = "category";
	public static final String PUBDATE = "pubDate";
    public static final String THUMBNAIL = "thumbnail";

	private XmlPullParser parser;
	
	public ParserNoticias(String xmlTxt) 
	{
		parser = Xml.newPullParser();		
		try {
            //Obtengo un stringreader a partir de un string (será la fuente de información del parser)
			parser.setInput(new StringReader(xmlTxt));
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Noticia> parseListaNoticias()
	{
		ArrayList<Noticia> noticias = null;		
		int event; //Numeros que identificarán el tipo de información que va encontrando el parser
		Noticia noticia = null;
		
        try
        {
        	event = parser.getEventType(); 
            while (event != XmlPullParser.END_DOCUMENT) //Constantes que hacen referencia a la info encontrada
            {
                String tag = null;
 
                switch (event)
                {
                    case XmlPullParser.START_DOCUMENT:
 
                        noticias = new ArrayList<Noticia>();
                        break;
 
                    case XmlPullParser.START_TAG:
 
                        tag = parser.getName();
 
                        if (tag.equals(ITEM))
                        {
                        	// inicio del tag <item>
                            noticia = new Noticia();
                        }
                        else if (noticia != null)   //Controlo que esté parseando tags dentro de una Noticia
                        {
                        	// Tags dentro de <item></item>                        	
                            if (tag.equals(LINK))
                            {
                                noticia.setLink(parser.nextText()); //nextText() devuelve el contenido entre tags de XML
                            }
                            else if (tag.equals(DESCRIPTION))
                            {
                                noticia.setDescription(parser.nextText());
                            }
                            else if (tag.equals(PUBDATE))
                            {
                                noticia.setPubDate(parser.nextText());
                            }
                            else if (tag.equals(TITLE))
                            {
                                noticia.setTitle(parser.nextText()); //Asigno el contenido entre tags a la propiedad Title
                            }
                            //else if (tag.equals(THUMBNAIL))
                            else if (tag.equals("content")) //El nombre del tag corresponderá con lo la palabra que sigue a los dos puntos
                            {
                                //Mejorar código
                                String w = parser.getAttributeValue(null,"width");  //Leo el valor de un atributo
                                if(w.equals("256")) // me quedo con las mas chica
                                    noticia.setImageUrl(parser.getAttributeValue(null,"url"));
                            }
                        }
                        break;
 
                    case XmlPullParser.END_TAG:
 
                    	// se llago al final del tag </item>
                        tag = parser.getName();
 
                        if (tag.equals(ITEM) && noticia != null)
                        {
                        	// agrego el objeto noticia a la lista
                            noticias.add(noticia);                            
                            noticia=null;
                        }
                        break;
                }
 
                event = parser.next();  //Sigo leyendo un poco más del string XML
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
 
        return noticias;
    }
}
