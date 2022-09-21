package br.com.palota.cinema.dto;

import lombok.Data;

@Data
public class TicketBuyRequest {

    private String customerName;

    private Integer seat;

    private Long sessionId;
}
