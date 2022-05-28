package hu.bnpi.dhte.inventory.models;

import hu.bnpi.dhte.inventory.dtos.InventoryItemDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class DeliveryNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToMany
    private List<InventoryItem> items;

    private Long oldResponsibleId;

    private Long newResponsibleId;

    public void validateOldResponsible() {
        validateResponsible(oldResponsibleId);
        List<InventoryItem> invalidItems = items.stream()
                .filter(item -> item.getResponsibleId() != oldResponsibleId)
                .toList();
        if (!invalidItems.isEmpty()) {
            throw new IllegalArgumentException("Responsible doesn't have items: " + invalidItems);
        }
    }

    public void validateNewResponsible() {
        validateResponsible(newResponsibleId);
    }

    private void validateResponsible(Long newResponsibleId) {
        //We can implement it after Employee and Department Microservices implemented.
    }

    public void updateInventoryItemsByDeliveryNote() {
        items.forEach(this::updateResponsible);
        //This method will be moved into service.
    }

    private InventoryItem updateResponsible(InventoryItem inventoryItem) {
        inventoryItem.setResponsibleId(newResponsibleId);
        //Responsible type must be implemented after Employee and Department
        // Microservices implemented
        return inventoryItem;
    }
}