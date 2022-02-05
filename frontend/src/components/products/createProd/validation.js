
import * as Yup from 'yup';

const validationFields= () => {
    return Yup.object({
        name: Yup.string()
            .required("Укажите название товара"),
    });
}
export default validationFields;