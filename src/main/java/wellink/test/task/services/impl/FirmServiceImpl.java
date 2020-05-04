package wellink.test.task.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import wellink.test.task.entities.materials.*;
import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.enums.*;
import wellink.test.task.interfaces.BasicCRUDService;
import wellink.test.task.models.Clothes;
import wellink.test.task.models.Material;
import wellink.test.task.models.SoldGoods;
import wellink.test.task.services.FirmService;
import wellink.test.task.services.LogService;
import wellink.test.task.services.materials.*;
import wellink.test.task.services.products.DenimCapService;
import wellink.test.task.services.products.DenimJacketService;
import wellink.test.task.services.products.DenimPantsService;
import wellink.test.task.services.products.DenimSneakersService;

import java.util.*;

@Service
public class FirmServiceImpl implements FirmService {

    @Autowired
    private LogService logService;

    // MATERIALS
    @Autowired
    private DenimService denimService;
    @Autowired
    private ThreadRollService threadRollService;
    @Autowired
    private ButtonService buttonService;
    @Autowired
    private LaceService laceService;
    @Autowired
    private LockService lockService;
    @Autowired
    private ShoeSoleService shoeSoleService;

    // CLOTHES
    @Autowired
    private DenimCapService denimCapService;
    @Autowired
    private DenimJacketService denimJacketService;
    @Autowired
    private DenimPantsService denimPantsService;
    @Autowired
    private DenimSneakersService denimSneakersService;


    @Override
    public DenimCap makingDenimCap(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            Integer visorLength, DenimCap.CapType capType, Boolean hasCapSizeAdjustment
    ) {

        Map<String, Object> map = canMakeDenimCap(color, size, visorLength, hasCapSizeAdjustment);
        double price = 0;

        List<Denim> denimList = (List<Denim>) map.get(Denim.class.getSimpleName());
        List<ThreadRoll> threadRollList = (List<ThreadRoll>) map.get(ThreadRoll.class.getSimpleName());
        List<Button> buttonList = (List<Button>) map.get(Button.class.getSimpleName());;

        if (denimList == null || threadRollList == null) return null;

        price += countTotalPrice(denimList);
        price += countTotalPrice(threadRollList);

        if (buttonList != null) price += countTotalPrice(buttonList);

        if (
                denimService.deleteAll(denimList)
                && threadRollService.deleteAll(threadRollList)
                && ((map.size() == 3) && (buttonService.deleteAll(buttonList)) || map.size() == 2)
        ) {
            DenimCap denimCap = new DenimCap(name, price, color, size, Density.HIGH, forWhatGender, forWhatAge);
            denimCapService.save(denimCap);

            return denimCap;
        }

        return null;
    }



    @Override
    public DenimJacket makingDenimJacket(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            Boolean hasHood, Integer pocketsNumber, Integer sleeveLength, Boolean isInsulated, ClosureType closureType
    ) {

        Map<String, Object> map = canMakeDenimJacket(color, size, hasHood, pocketsNumber, forWhatAge, sleeveLength, isInsulated, closureType);
        double price = 0;

        List<Denim> denimList = (List<Denim>) map.get(Denim.class.getSimpleName());
        List<ThreadRoll> threadRollList = (List<ThreadRoll>) map.get(ThreadRoll.class.getSimpleName());
        List<Button> buttonList = (List<Button>) map.get(Button.class.getSimpleName());
        List<Lace> laceList = (List<Lace>) map.get(Lace.class.getSimpleName());
        List<Lock> lockList = (List<Lock>) map.get(Lock.class.getSimpleName());

        if (denimList == null || threadRollList == null) return null;

        price += countTotalPrice(denimList);
        price += countTotalPrice(threadRollList);

        if (buttonList != null) price += countTotalPrice(buttonList);
        if (laceList != null) price += countTotalPrice(laceList);
        if (lockList != null) price += countTotalPrice(lockList);

        boolean denimListIsDeleted = denimService.deleteAll(denimList);
        boolean threadRollListIsDeleted = threadRollService.deleteAll(threadRollList);
        boolean buttonListIsDeleted = (buttonList != null) ? buttonService.deleteAll(buttonList) : true;
        boolean laceListIsDeleted = (laceList != null) ? laceService.deleteAll(laceList) : true;
        boolean lockListIsDeleted = (lockList != null) ? lockService.deleteAll(lockList) : true;

        if (denimListIsDeleted && threadRollListIsDeleted && buttonListIsDeleted && laceListIsDeleted && lockListIsDeleted) {

            DenimJacket denimJacket = new DenimJacket(name, price, color, size, Density.HIGH, forWhatGender,
                    forWhatAge, hasHood, pocketsNumber, sleeveLength, isInsulated, closureType);
            denimJacketService.save(denimJacket);

            return denimJacket;
        }

        return null;
    }

    @Override
    public DenimPants makingDenimPants(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            Integer pocketsNumber, Boolean isSkinny, Boolean isStretch, ClosureType closureType, Boolean isInsulated
    ) {

        Map<String, Object> map = canMakeDenimPants(color, size, pocketsNumber, isSkinny, closureType, isInsulated);
        double price = 0;

        List<Denim> denimList = (List<Denim>) map.get(Denim.class.getSimpleName());
        List<ThreadRoll> threadRollList = (List<ThreadRoll>) map.get(ThreadRoll.class.getSimpleName());
        List<Button> buttonList = (List<Button>) map.get(Button.class.getSimpleName());
        List<Lock> lockList = (List<Lock>) map.get(Lock.class.getSimpleName());

        if (denimList == null || threadRollList == null) return null;

        price += countTotalPrice(denimList);
        price += countTotalPrice(threadRollList);

        if (buttonList != null) price += countTotalPrice(buttonList);
        if (lockList != null) price += countTotalPrice(lockList);

        boolean denimListIsDeleted = denimService.deleteAll(denimList);
        boolean threadRollListIsDeleted = threadRollService.deleteAll(threadRollList);
        boolean buttonListIsDeleted = (buttonList != null) ? buttonService.deleteAll(buttonList) : true;
        boolean lockListIsDeleted = (lockList != null) ? lockService.deleteAll(lockList) : true;

        if (denimListIsDeleted && threadRollListIsDeleted && buttonListIsDeleted && lockListIsDeleted) {

            DenimPants denimPants = new DenimPants(name, price, color, size, Density.HIGH, forWhatGender,
                    forWhatAge, pocketsNumber, isSkinny, isStretch, closureType, isInsulated);
            denimPantsService.save(denimPants);

            return denimPants;
        }

        return null;
    }

    @Override
    public DenimSneakers makingDenimSneakers(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            ClosureType closureType, ShoeSole.SoleThickness soleThickness, Boolean isInsulated, Stiffness stiffness
    ) {

        Map<String, Object> map = canMakeDenimSneakers(color, size, closureType, isInsulated);
        double price = 0;

        List<Denim> denimList = (List<Denim>) map.get(Denim.class.getSimpleName());
        List<ThreadRoll> threadRollList = (List<ThreadRoll>) map.get(ThreadRoll.class.getSimpleName());
        List<Lock> lockList = (List<Lock>) map.get(Lock.class.getSimpleName());
        List<Lace> laceList = (List<Lace>) map.get(Lace.class.getSimpleName());
        List<ShoeSole> shoeSoleList = (List<ShoeSole>) map.get(ShoeSole.class.getSimpleName());


        if (denimList == null || threadRollList == null || shoeSoleList == null) return null;

        price += countTotalPrice(denimList);
        price += countTotalPrice(threadRollList);
        price += countTotalPrice(shoeSoleList);

        if (laceList != null) price += countTotalPrice(laceList);
        if (lockList != null) price += countTotalPrice(lockList);

        boolean denimListIsDeleted = denimService.deleteAll(denimList);
        boolean threadRollListIsDeleted = threadRollService.deleteAll(threadRollList);
        boolean shoeSoleListIsDeleted = shoeSoleService.deleteAll(shoeSoleList);
        boolean buttonListIsDeleted = (laceList != null) ? laceService.deleteAll(laceList) : true;
        boolean lockListIsDeleted = (lockList != null) ? lockService.deleteAll(lockList) : true;

        if (denimListIsDeleted && threadRollListIsDeleted && shoeSoleListIsDeleted && buttonListIsDeleted && lockListIsDeleted) {

            DenimSneakers denimSneakers = new DenimSneakers(name, price, color, size, Density.HIGH, forWhatGender,
                    forWhatAge, closureType, soleThickness, isInsulated, stiffness);
            denimSneakersService.save(denimSneakers);

            return denimSneakers;
        }

        return null;
    }



    private Map<String, Object> canMakeDenimCap(Color color, Size size, Integer visorLength, boolean hasCapSizeAdjustment) {

        Map<String, Object> map = new HashMap<>();

        // (XS 1, S - 1, M - 2, L - 2, XL - 3
        int denimNumber = 0;

        switch (size) {
            case XS:
            case S:
                denimNumber = 1;
                break;
            case M:
            case L:
                denimNumber = 2;
                break;
            case XL:
                denimNumber = 3;
                break;
        }

        if (10 < visorLength && visorLength <= 15) {
            denimNumber += 1;
        } else if (15 < visorLength && visorLength <= 30) {
            denimNumber += 2;
        }

        List<Denim> denimList = denimService.getAllByColor(color, PageRequest.of(0, denimNumber));
        List<ThreadRoll> threadRollList = threadRollService.getAllByColor(color, PageRequest.of(0, 1));

        if (denimList.size() == denimNumber && threadRollList.size() == 1) {
            map.put(Denim.class.getSimpleName(), denimList);
            map.put(ThreadRoll.class.getSimpleName(), threadRollList);
        }

        if (hasCapSizeAdjustment) {
            List<Button> buttonList = buttonService.getAllByColor(color, PageRequest.of(0, 1));

            if (buttonList.size() == 1) {
                map.put(Button.class.getSimpleName(), buttonList);
            }
        }

        return map;
    }

    private Map<String, Object> canMakeDenimJacket(Color color, Size size, Boolean hasHood, Integer pocketsNumber, Age forWhatAge,
                                    Integer sleeveLength, Boolean isInsulated, ClosureType closureType) {

        Map<String, Object> map = new HashMap<>();

        // XS - 10, S - 11, M -12, L - 13, XL- 14
        int denimNumber = 0;

        switch (size) {
            case XS:
                denimNumber = 10;
                break;
            case S:
                denimNumber = 11;
                break;
            case M:
                denimNumber = 12;
                break;
            case L:
                denimNumber = 13;
                break;
            case XL:
                denimNumber = 14;
                break;
            default:
                denimNumber = 10;
                break;
        }

        if (hasHood) {
            List<Lace> laceList = laceService.getAllByColor(color, PageRequest.of(0, 1));
            if (laceList.size() == 0) return map;
            map.put(Lace.class.getSimpleName(), laceList);

            switch (forWhatAge) {
                case FOR_CHILDREN:
                    denimNumber += 1;
                    break;
                case FOR_TEENAGERS:
                    denimNumber += 2;
                    break;
                case FOR_ADULTS:
                    denimNumber += 3;
                    break;
                default:
                    denimNumber += 1;
                    break;
            }
        }

        denimNumber += pocketsNumber * 2;

        switch (sleeveLength) {
            case 0:
                break;
            case 1:
                denimNumber += 1;
                break;
            case 2:
                denimNumber += 2;
                break;
            case 3:
                denimNumber += 3;
                break;
            case 4:
                denimNumber += 4;
                break;
            default:
                break;
        }

        if (isInsulated) denimNumber += 5;

        List<Denim> denimList = denimService.getAllByColor(color, PageRequest.of(0, denimNumber));
        List<ThreadRoll> threadRollList = threadRollService.getAllByColor(color, PageRequest.of(0, denimNumber));

        if (denimList.size() == denimNumber && threadRollList.size() == denimNumber) {
            map.put(Denim.class.getSimpleName(), denimList);
            map.put(ThreadRoll.class.getSimpleName(), threadRollList);
        }

        if (closureType == ClosureType.BUTTON) {
            List<Button> buttonList = buttonService.getAllByColor(color, PageRequest.of(0, 10));

            if (buttonList.size() == 10) map.put(Button.class.getSimpleName(), buttonList);

        } else if (closureType == ClosureType.ZIPPER) {
            List<Lock> lockList = lockService.getAllByColor(color, PageRequest.of(0, 9));

            if (lockList.size() == 9) map.put(Lock.class.getSimpleName(), lockList);
        }

        return map;
    }

    private Map<String, Object> canMakeDenimPants(Color color, Size size, Integer pocketsNumber, Boolean isSkinny,
                                                  ClosureType closureType, Boolean isInsulated) {

        Map<String, Object> map = new HashMap<>();

        // XS - 7, S - 8, M - 9, L - 10, XL- 11
        int denimNumber = 0;

        switch (size) {
            case XS:
                denimNumber = 7;
                break;
            case S:
                denimNumber = 8;
                break;
            case M:
                denimNumber = 9;
                break;
            case L:
                denimNumber = 10;
                break;
            case XL:
                denimNumber = 11;
                break;
            default:
                denimNumber = 7;
                break;
        }

        denimNumber += pocketsNumber * 2;

        if (isSkinny) denimNumber--;

        if (isInsulated) denimNumber += 5;

        List<Denim> denimList = denimService.getAllByColor(color, PageRequest.of(0, denimNumber));
        List<ThreadRoll> threadRollList = threadRollService.getAllByColor(color, PageRequest.of(0, denimNumber));

        if (denimList.size() == denimNumber && threadRollList.size() == denimNumber) {
            map.put(Denim.class.getSimpleName(), denimList);
            map.put(ThreadRoll.class.getSimpleName(), threadRollList);
        }

        if (closureType == ClosureType.BUTTON) {
            List<Button> buttonList = buttonService.getAllByColor(color, PageRequest.of(0, 7));

            if (buttonList.size() == 7) map.put(Button.class.getSimpleName(), buttonList);

        } else if (closureType == ClosureType.ZIPPER) {
            List<Lock> lockList = lockService.getAllByColor(color, PageRequest.of(0, 4));

            if (lockList.size() == 4) map.put(Lock.class.getSimpleName(), lockList);
        }

        return map;
    }

    private Map<String, Object> canMakeDenimSneakers(Color color, Size size, ClosureType closureType, Boolean isInsulated) {

        Map<String, Object> map = new HashMap<>();

        // XS - 1, S - 2, M - 3, L - 4, XL- 5
        int denimNumber = 0;

        switch (size) {
            case XS:
                denimNumber = 1;
                break;
            case S:
                denimNumber = 2;
                break;
            case M:
                denimNumber = 3;
                break;
            case L:
                denimNumber = 4;
                break;
            case XL:
                denimNumber = 5;
                break;
            default:
                denimNumber = 1;
                break;
        }

        if (isInsulated) denimNumber += 2;

        List<ShoeSole> shoeSoleList = shoeSoleService.getAllByColor(color, PageRequest.of(0, 2));
        List<Denim> denimList = denimService.getAllByColor(color, PageRequest.of(0, denimNumber));
        List<ThreadRoll> threadRollList = threadRollService.getAllByColor(color, PageRequest.of(0, denimNumber));

        if (shoeSoleList.size() == 2) map.put(ShoeSole.class.getSimpleName(), shoeSoleList);

        if (denimList.size() == denimNumber && threadRollList.size() == denimNumber) {
            map.put(Denim.class.getSimpleName(), denimList);
            map.put(ThreadRoll.class.getSimpleName(), threadRollList);
        }

        if (closureType == ClosureType.LACE_UP) {
            List<Lace> laceList = laceService.getAllByColor(color, PageRequest.of(0, 2));

            if (laceList.size() == 2) map.put(Lace.class.getSimpleName(), laceList);

        } else if (closureType == ClosureType.ZIPPER) {
            List<Lock> lockList = lockService.getAllByColor(color, PageRequest.of(0, 2));

            if (lockList.size() == 2) map.put(Lock.class.getSimpleName(), lockList);
        }

        return map;
    }

    public Double countTotalPrice(List<? extends Material> materialList) {
        double price = 0;

        for (Material material : materialList) { price += material.getPrice(); }

        return price;
    }

    public <C extends Clothes, S> List<C> checkProducts (List<C> clothes, BasicCRUDService<S> service) {
        List<C> list = new ArrayList<>();

        for (C c : clothes) {
            C foundedClothes = (C) service.getById(c.getId());
            if (foundedClothes == null) return null;
            list.add(foundedClothes);
        }

        return list;
    }

    public <C extends Clothes, S> SoldGoods<C> sellProducts(List<C> clothes, BasicCRUDService<S> service) {

        List<S> list = (List<S>) checkProducts(clothes, service);

        if (list == null) return null;

        Double price = countTotalPrice((List<? extends Material>) list);

        boolean isDeleted = service.deleteAll(list);

        if (!isDeleted) return null;

        return new SoldGoods<C>(price, (List<C>) list);
    }
}
