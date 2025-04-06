document.getElementById('registerForm').onsubmit = async (e) => {
    e.preventDefault();

    const phone = document.getElementById('registerPhone').value;
    const username = document.getElementById('registerUsername').value;
    const password = document.getElementById('registerPassword').value;
    const confirmPassword = document.getElementById('registerConfirmPassword').value;
    const errorMessage = document.getElementById('registerError');

    if (password !== confirmPassword) {
        errorMessage.textContent = 'Пароли не совпадают';
        errorMessage.style.display = 'block';
        return;
    }

    try {
        const response = await fetch('/api/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ phone, username, password })
        });

        if (response.ok) {
            alert('Регистрация успешна! Теперь вы можете войти.');
            window.location.href = 'index.html';
        } else {
            const data = await response.json();
            errorMessage.textContent = data.message || 'Ошибка регистрации';
            errorMessage.style.display = 'block';
        }
    } catch (error) {
        console.error('Ошибка при регистрации:', error);
        errorMessage.textContent = 'Произошла ошибка при регистрации';
        errorMessage.style.display = 'block';
    }
};