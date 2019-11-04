package it.unipi.meteorites;

import org.apache.avro.Schema;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.serialization.AbstractAvroEventSerializer;
import org.apache.flume.serialization.EventSerializer;
import org.json.JSONObject;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class MeteoriteSerializer extends  AbstractAvroEventSerializer<Meteorite>{
    private static final Schema SCHEMA = new Schema.Parser().parse(
            new String("{\"name\": \"meteorite\",\"type\": \"record\",\"namespace\": \"it.unipi.GeoElaborator\",\"fields\": [" +
                    "{\"name\": \"year\",\"type\": \"long\"},{\"name\": \"mass\",\"type\": \"int\"},{\"name\": \"lat\",\"type\": \"string\"},{\"name\": \"lon\",\"type\": \"string\"},{\"name\": \"recclass\",\"type\": \"string\"}," +
                    "{\"name\": \"resolved\",\"type\": \"boolean\"},{\"name\": \"info\",\"type\": {\"name\": \"info\",\"type\": \"record\",\"fields\": [" +
                    "{\"name\": \"Name\",\"type\": \"string\",\"default\": \"null\"},{\"name\": \"State\",\"type\": \"string\",\"default\": \"null\"},{\"name\": \"Country\",\"type\": \"string\",\"default\": \"null\"}]}}]}")
    );

    private final OutputStream out;

    private MeteoriteSerializer(OutputStream out) {
        this.out = out;
    }

    @Override
    protected Schema getSchema() {
        return SCHEMA;
    }
    @Override
    protected OutputStream getOutputStream() {
        return out;
    }
    protected Meteorite convert(Event event){
        Meteorite m = new Meteorite();
        JSONObject job;
        try {
            job = new JSONObject(new String(event.getBody(), "ISO-8859-1"));
            //m.setYear((new String(job.get("year").toString().getBytes(),"ISO-8859-1")));
            m.setYear(job.getLong("year"));
            m.setLat((new String(job.get("lat").toString().getBytes(),"ISO-8859-1")));
            m.setLon((new String(job.get("lon").toString().getBytes(),"ISO-8859-1")));
            //m.setMass((new String(job.get("mass").toString().getBytes(),"ISO-8859-1")));
            m.setMass(job.getInt("mass"));
            m.setRecclass(new String(job.get("recclass").toString().getBytes(),"ISO-8859-1"));
            m.setResolved(job.getBoolean("resolved"));
            //m.setResolved((new String(job.get("resolved").toString().getBytes(),"ISO-8859-1")));
            AdditionalInfo ai;
            if (m.isResolved()){
                JSONObject info = job.getJSONObject("info");
                String name ;
                String state ;
                String country ;
                if(info.has("State")) state=new String(info.get("State").toString().getBytes(),"ISO-8859-1");
                else state=new String("".getBytes(),"ISO-8859-1");
                if(info.has("Country")) country=new String(info.get("Country").toString().getBytes(),"ISO-8859-1");
                else country=new String("".getBytes(),"ISO-8859-1");
                if(info.has("Name")) name=new String(info.get("Name").toString().getBytes(),"ISO-8859-1");
                else name=new String("".getBytes(),"ISO-8859-1");
                ai =new AdditionalInfo(name,state,country);
            }
            else{
                ai = new AdditionalInfo(new String("null".getBytes(),"ISO-8859-1"),new String("null".getBytes(),"ISO-8859-1"),new String("null".getBytes(),"ISO-8859-1"));
            }
            m.setInfo(ai);
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return m;
    }

    public static class Builder implements EventSerializer.Builder {
        public EventSerializer build(Context context, OutputStream out) {
            MeteoriteSerializer writer = new MeteoriteSerializer(out);
            writer.configure(context);
            return writer;
        }
    }
}
