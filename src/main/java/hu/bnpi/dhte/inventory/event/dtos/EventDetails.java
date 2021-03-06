package hu.bnpi.dhte.inventory.event.dtos;

import hu.bnpi.dhte.inventory.event.model.EventType;
import hu.bnpi.dhte.inventory.inventoryitem.dtos.InventoryItemDetails;
import hu.bnpi.dhte.inventory.responsible.model.Responsible;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDetails {

    private Long id;

    private LocalDate date;

    private String noteNumber;

    private List<InventoryItemDetails> items;

    private EventType eventType;

    private String description;

    private Responsible oldResponsible;

    private Responsible newResponsible;
}
