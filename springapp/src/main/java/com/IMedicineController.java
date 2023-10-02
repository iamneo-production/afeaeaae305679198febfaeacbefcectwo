
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicines")
public class IMedicineController {
    private Map<Integer, Medicine> medicineMap = new HashMap<>();
    private int currentId = 1;

    // Endpoint to add a new medicine
    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        medicine.setMedicineId(currentId++);
        medicineMap.put(medicine.getMedicineId(), medicine);
        return true;
    }

    // Endpoint to update an existing medicine
    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        if (medicineMap.containsKey(medicineId)) {
            Medicine existingMedicine = medicineMap.get(medicineId);
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
            existingMedicine.setPrice(updatedMedicine.getPrice());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());
            existingMedicine.setDescription(updatedMedicine.getDescription());
            return existingMedicine;
        }
        return null; // Handle error when medicineId is not found
    }
}