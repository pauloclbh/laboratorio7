package org.acme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("reajusteboleto")
public class BoletoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{valor}/{dataVendimento}/{dataPagamento}")
	public Response getBoletoReajustado(@PathParam("valor") Double valor,
			@PathParam("dataVendimento") String dataVendimento, @PathParam("dataPagamento") String dataPagamento) {
		Double resultado = valor;

		LocalDate vencimento = null;
		LocalDate pagamento = null;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		vencimento = LocalDate.parse(dataVendimento, formatter);
		pagamento = LocalDate.parse(dataPagamento, formatter);

		Long diasPassados = ChronoUnit.DAYS.between(vencimento, pagamento);

		if (diasPassados >= 1) {
			resultado = valor + valor * diasPassados * 0.1 / 100;
		}

		return Response.ok(resultado).build();
	}
}
