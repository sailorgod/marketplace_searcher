let selectedCategory = '';

async function loadStores(category) {
    selectedCategory = category;
    const storesList = document.getElementById('storesList');
    const storesLinks = document.getElementById('storesLinks');

    try {
        let url = category !== 'all'
            ? `/api/stores?category=${category}` : '/api/all_stores';
        let headerText = category !== 'all'
            ? 'Поиск будет осуществляться по магазинам:' : 'Поиск будет осуществляться по всем категориям:';

        const response = await fetch(url);
        const stores = await response.json();

        storesList.querySelector('h3').textContent = headerText;
        storesLinks.innerHTML = stores
            .map(store => `<a href="${store.url}" target="_blank">${store.name}</a>`)
            .join('');
    } catch (error) {
        console.error('Ошибка при загрузке магазинов:', error);
    }
}

async function loadPopular() {
    const popularList = document.getElementById('popularList');
    try {
        const response = await fetch('/api/popular');
        const popularItems = await response.json();

        popularList.innerHTML = popularItems.map(item => `
            <div class="product-card">
                <img src="${item.image}" alt="${item.name}" class="product-image">
                <div class="product-info">
                    <h3>${item.name}</h3>
                    ${item.discountPrice ? `
                        <span class="price">${item.price} ₽</span>
                        <span class="discount-price">${item.discountPrice} ₽</span>
                    ` : `
                        <span>${item.price} ₽</span>
                    `}
                    <p><a href="${item.link}" target="_blank">Перейти к товару</a></p>
                </div>
            </div>
        `).join('');
    } catch (error) {
        console.error('Ошибка при загрузке популярных товаров:', error);
        popularList.innerHTML = '<p>Не удалось загрузить популярные товары</p>';
    }
}

async function searchProducts() {
    const query = document.getElementById('searchInput').value;
    const productsList = document.getElementById('productsList');
    const popularSection = document.getElementById('popularSection');

    if (!query) {
        popularSection.style.display = 'block'; // Показываем популярное, если запрос пустой
        productsList.innerHTML = '';
        return;
    }

    popularSection.style.display = 'none'; // Скрываем популярное при поиске
    productsList.innerHTML = `
        <div class="loading-container">
            <img src="./_s_tarelkami_gif_yapfiles.ru.gif" alt="Loading">
            <p>Подбираем результаты для вас</p>
        </div>
    `;

    try {
        const url = selectedCategory
            ? `/api/products?category=${selectedCategory}&query=${encodeURIComponent(query)}`
            : `/api/products?query=${encodeURIComponent(query)}`;
        const response = await fetch(url);
        const products = await response.json();

        if (products.length === 0) {
            productsList.innerHTML = `
                <div class="empty-result">
                    <p>Ничего не найдено</p>
                </div>
            `;
        } else {
            productsList.innerHTML = products.map(product => `
                <div class="product-card">
                    <img src="${product.image}" alt="${product.name}" class="product-image">
                    <div class="product-info">
                        <h3>${product.name}</h3>
                        ${product.discountPrice ? `
                            <span class="price">${product.price} ₽</span>
                            <span class="discount-price">${product.discountPrice} ₽</span>
                        ` : `
                            <span>${product.price} ₽</span>
                        `}
                        <p><a href="${product.link}" target="_blank">Перейти к товару</a></p>
                    </div>
                </div>
            `).join('');
        }
    } catch (error) {
        console.error('Ошибка при поиске товаров:', error);
        productsList.innerHTML = `
            <div class="empty-result">
                <p>Произошла ошибка при поиске</p>
            </div>
        `;
    }
}

function showLoginForm() {
    const modal = document.getElementById('loginModal');
    modal.style.display = 'flex';

    modal.onclick = (e) => {
        if (e.target === modal) {
            modal.style.display = 'none';
        }
    };

    document.getElementById('loginForm').onsubmit = async (e) => {
        e.preventDefault();
        const username = document.getElementById('loginUsername').value;
        const password = document.getElementById('loginPassword').value;

        try {
            const response = await fetch('/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username, password })
            });
            if (response.ok) {
                modal.style.display = 'none';
                alert('Вход выполнен успешно!');
            } else {
                alert('Ошибка входа. Проверьте логин и пароль.');
            }
        } catch (error) {
            console.error('Ошибка при входе:', error);
            alert('Произошла ошибка при входе.');
        }
    };
}

// Загрузка данных при старте страницы
window.onload = () => {
    loadStores('all'); // Все категории
    loadPopular();  // Популярные товары
};

// Обработка Enter в поле ввода
document.getElementById('searchInput').addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        searchProducts();
    }
});