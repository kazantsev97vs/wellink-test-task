package wellink.test.task.services;

import wellink.test.task.entities.materials.ShoeSole;
import wellink.test.task.entities.products.DenimCap;
import wellink.test.task.entities.products.DenimJacket;
import wellink.test.task.entities.products.DenimPants;
import wellink.test.task.entities.products.DenimSneakers;
import wellink.test.task.enums.*;

/**
 * Сервис имитирующий работу фирмы
 */
public interface FirmService {

    /**
     * Изготовление джинсовой кепки
     * @param name - название модели
     * @param color - цвет кепки
     * @param size - размер кепки (XS 1, S - 1, M - 2, L - 2, XL - 3 джинсовой ткани)
     * @param forWhatGender - для мужчин, для женщин, универсальная
     * @param forWhatAge - для детей, для подростков, для взрослых
     * @param visorLength - длина козырька 10-15 см - +1 джинсовая ткань; 15-30 - +2 джинсовой ткани
     * @param capType - тип кепки
     * @param hasCapSizeAdjustment - регулируемая по размеру
     * @return изготовленная джинсовая кепка
     */
    DenimCap makingDenimCap(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            Integer visorLength, DenimCap.CapType capType, Boolean hasCapSizeAdjustment
    );

    /**
     * Изготовление джинсовой куртки
     * @param name - название модели
     * @param color - цвет куртки
     * @param size - размер куртки (XS - 10, S - 11, M -12, L - 13, XL- 14 джинсовой ткани)
     * @param forWhatGender - для мужчин, для женщин, универсальная
     * @param forWhatAge - для детей, для подростков, для взрослых
     * @param hasHood - имеется ли капюшон (если да: для детей + 1, для подростков - 2, для взрослых + 3 ткани)
     * @param pocketsNumber - 2-8 карманов (каждые 2 кармана - 1 ткань)
     * @param sleeveLength - 0 - нет рукавов, 1 - 1/4 + 1 ткань, 2 - 2/4 + 2 ткани, 3 - 3/4 + 3 ткани, 4 - 4/4 + 4 ткани
     * @param isInsulated - не утепленная + 0, утепленная + 5 тканей
     * @param closureType застегивается на пуговицах или на замках
     * @return изготовленная джинсовая куртка
     */
    DenimJacket makingDenimJacket(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            Boolean hasHood, Integer pocketsNumber, Integer sleeveLength, Boolean isInsulated, ClosureType closureType
    );

    /**
     * Изготовление джинсовых штанов
     * @param name - название модели
     * @param color - цвет штанов
     * @param size - размер штанов (XS - 7, S - 8, M - 9, L - 10, XL- 11 джинсовой ткани)
     * @param forWhatGender - для мужчин, для женщин, универсальная
     * @param forWhatAge - для детей, для подростков, для взрослых
     * @param pocketsNumber - 2-6 карманов (каждые 2 кармана - 1 ткань)
     * @param isSkinny зауженные -1 ткань
     * @param isStretch тянущиеся
     * @param closureType застегиваются на пуговицах или на замках
     * @param isInsulated - не утепленные + 0, утепленные + 5 тканей
     * @return изготовленная джинсовые штаны
     */
    DenimPants makingDenimPants(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            Integer pocketsNumber, Boolean isSkinny, Boolean isStretch, ClosureType closureType, Boolean isInsulated
    );

    /**
     * Изготовление джинсовых кроссовок
     * @param name - название модели
     * @param color - цвет штанов
     * @param size - размер штанов (XS - 3, S - 4, M - 5, L - 6, XL- 7 джинсовой ткани)
     * @param forWhatGender - для мужчин, для женщин, универсальная
     * @param forWhatAge - для детей, для подростков, для взрослых
     * @param closureType застегиваются на шнурках или на замках
     * @param soleThickness - толщина подошвы
     * @param isInsulated - не утепленные + 0, утепленные + (размер штанов / 2) тканей
     * @param stiffness жесткость подошвы
     * @return изготовленная джинсовые кроссовки
     */
    DenimSneakers makingDenimSneakers(
            String name, Color color,
            Size size, Gender forWhatGender, Age forWhatAge,
            ClosureType closureType, ShoeSole.SoleThickness soleThickness, Boolean isInsulated, Stiffness stiffness
    );


//    /**
//     * Создание джинсовой кепки
//     * @param denimList - 1-2 джинсовой ткани
//     * @param threadRoll - 1 рулон ниток
//     * @param button - 0-1 пуговица (для регулировки размера на задней части кепки, если она есть)
//     * @return изготовленная джинсовая кепка
//     */
//    DenimCap createDenimCap(
//            List<Denim> denimList,
//            ThreadRoll threadRoll,
//            Button button
//    );
//
//    /**
//     * Изготовление джинсовой куртки
//     * @param buttonList - 0-14 пуговиц
//     * @param denimList - 10-15 джинсовой ткани
//     * @param lace - 0-1 шнурок (для капюшона, если он есть)
//     * @param lockList - 0-9 замков
//     * @param threadRollList - 10-15 рулонов ниток (по одному на одну джинсовую ткань)
//     * @return изготовленная джинсовая куртка
//     */
//    DenimJacket createDenimJacket(
//            List<Button> buttonList,
//            List<Denim> denimList,
//            Lace lace,
//            List<Lock> lockList,
//            List<ThreadRoll> threadRollList
//    );
//
//    /**
//     * Изготовление джинсовых штанов
//     * @param buttonList - 0-7 пуговиц
//     * @param denimList - 7-12 джинсовой ткани
//     * @param lockList - 0-4 замков
//     * @param threadRollList - 7-12 рулонов ниток (по одному на одну джинсовую ткань)
//     * @return изготовленная джинсовые штаны
//     */
//    DenimPants createDenimPants(
//            List<Button> buttonList,
//            List<Denim> denimList,
//            List<Lock> lockList,
//            List<ThreadRoll> threadRollList
//    );
//
//    /**
//     * Изготовление джинсовых кроссовок
//     * @param denimList - 4 джинсовой ткани
//     * @param laceList - 2 шнурока
//     * @param threadRollList - 4 рулонов ниток (по одному на одну джинсовую ткань)
//     * @param shoeSoleList - 2 подошвы для обуви
//     * @return изготовленная джинсовые кроссовки
//     */
//    DenimSneakers createDenimSneakers(
//            List<Denim> denimList,
//            List<Lace> laceList,
//            List<ThreadRoll> threadRollList,
//            List<ShoeSole> shoeSoleList
//    );


}
