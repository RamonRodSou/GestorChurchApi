package br.com.technosou.gestor.serializer;

import br.com.technosou.gestor.enums.Gender;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<Gender> {

    @Override
    public void serialize(Gender gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String formatedGender = Gender.MALE.equals(gender) ? "M" : "F" ;
        jsonGenerator.writeString(formatedGender);
    }
}