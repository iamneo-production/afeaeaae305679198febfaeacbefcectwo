
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private List<Medicine> medicineList = new ArrayList<>();

    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        // Add logic to add medicine to the system
        // Return true if successful, otherwise false
    }

    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        // Add logic to update medicine with given ID
        // Return the updated Medicine object
    }
}
