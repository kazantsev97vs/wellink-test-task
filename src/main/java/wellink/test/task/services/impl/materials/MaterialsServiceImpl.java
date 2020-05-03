package wellink.test.task.services.impl.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.materials.Materials;
import wellink.test.task.repositories.materials.MaterialsRepository;
import wellink.test.task.services.materials.MaterialsService;

/**
 * Реализация CRUD-сервиса для работы с материалами
 */
@Service
public class MaterialsServiceImpl implements MaterialsService {

    @Autowired
    private MaterialsRepository materialsRepository;

    private final Long ID = 1L;

    @Override
    public Materials save(Materials materials) {
        materials.setId(ID);
        Materials savedMaterials = getById(ID);

        if (savedMaterials != null) {
            materials.setButtons(materials.getButtons() + savedMaterials.getButtons());
            materials.setButtons(materials.getDenims() + savedMaterials.getDenims());
            materials.setButtons(materials.getLaces() + savedMaterials.getLaces());
            materials.setButtons(materials.getLocks() + savedMaterials.getLocks());
            materials.setButtons(materials.getShoeSoles() + savedMaterials.getShoeSoles());
            materials.setButtons(materials.getThreadRolls() + savedMaterials.getThreadRolls());
        }

        return materialsRepository.save(materials);
    }

    @Override
    public Materials getById(Long id) {
        return materialsRepository.findById(ID).orElse(null);
    }

    @Override
    public Materials update(Materials materials) {
        materials.setId(ID);
        return materialsRepository.save(materials);
    }

    @Override
    public Boolean delete(Materials materials) {
        materialsRepository.delete(materials);
        return !materialsRepository.findById(materials.getId()).isPresent();
    }
}
