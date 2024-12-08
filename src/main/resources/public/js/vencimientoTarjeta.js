document.addEventListener('DOMContentLoaded', () => {
    const input = document.getElementById('expiryDate');
    const errorMessage = document.getElementById('error-message');

    input.addEventListener('blur', () => {
        const value = input.value;
        const regex = /^(0[1-9]|1[0-2])\/\d{4}$/;

        if (regex.test(value)) {
            const [month, year] = value.split('/');
            const date = new Date(year, month - 1);
            const currentDate = new Date();
            const currentYear = currentDate.getFullYear();
            const currentMonth = currentDate.getMonth() + 1;

            if (date.getMonth() === (month - 1) && date.getFullYear() === parseInt(year, 10)) {
                if (year < currentYear || (year === currentYear && month < currentMonth)) {
                    errorMessage.textContent = 'La fecha de vencimiento es anterior a la fecha actual.';
                    errorMessage.style.display = 'block';
                } else {
                    errorMessage.style.display = 'none';
                }
            } else {
                errorMessage.textContent = 'Fecha de vencimiento inválida.';
                errorMessage.style.display = 'block';
            }
        } else {
            errorMessage.textContent = 'Formato inválido. Usa MM/YYYY.';
            errorMessage.style.display = 'block';
        }
    });
});
