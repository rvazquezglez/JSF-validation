package converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import model.RFC;


@FacesConverter("converter.RFCConverter")
public class RFCConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Pattern rfcPattern = Pattern.compile("^([A-Z]{3,4})(\\d{6})(\\w{3})$");
		Matcher m = rfcPattern.matcher(value);
		if (!m.matches())
		{
			throw new ConverterException("Error en la conversion");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		sdf.setLenient(false);
		Date fecha = null;
		try {
			fecha = sdf.parse(m.group(2));
		} catch (ParseException e) {
			throw new ConverterException("Fecha invalida");
		}
		
		
		RFC rfc = new RFC();
		rfc.setHomonimia(m.group(3));
		rfc.setFecha(fecha);
		rfc.setSiglas(m.group(1));
		rfc.setMoral(rfc.getSiglas().length() == 3);
		return rfc;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
