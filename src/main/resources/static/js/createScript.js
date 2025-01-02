const _csrf = document.querySelector('meta[name="_csrf"]').content;
const _csrf_header = document.querySelector('meta[name="_csrf_header"]').content;

async function getRestaurantsBySearch() {
    const value = document.getElementById("search").value
    if (!value.trim()) {
        const restaurantSelect = document.getElementById("restaurant");
        restaurantSelect.innerHTML = '<option value="">==매장 선택==</option>'; // 초기화
        return;
    }

    try {
        const response = await axios.get(`http://localhost:8000/api/restaurant`, {
            params: {
                value: value
            },
            headers: {
                [_csrf_header]: _csrf
            }
        });

        const restaurants = response.data;

        const restaurantSelect = document.getElementById("restaurant");
        restaurantSelect.innerHTML = '<option value="">==매장 선택==</option>';

        if (restaurants.length > 0) {
            restaurants.forEach(restaurant => {
                const option = document.createElement("option");
                option.value = restaurant.id;
                option.textContent = restaurant.name;
                restaurantSelect.appendChild(option);
            });
        }
    } catch (error) {
        console.error("Error fetching restaurants:", error);
    }
}
