package exceptions;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider // Indica que essa classe é um provedor JAX-RS
public class MyExceptionMapper implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(Exception exception) {
    // Cria um objeto JSON com a mensagem de erro
    JsonObject error = Json.createObjectBuilder()
                           .add("message", exception.getMessage())
                           .build();
    // Retorna uma resposta com status 500 e o objeto JSON como corpo
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                   .type(MediaType.APPLICATION_JSON)
                   .entity(error)
                   .build();
  }
}

