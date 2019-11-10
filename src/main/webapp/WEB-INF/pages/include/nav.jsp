<nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100"
     id="sectionsNav">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" href="./home?id=${sessionScope.user.id}" >
                Chillout </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="dropdown nav-item">
                    <a class="nav-link" href="./products">
                        <i class="material-icons">storefront</i> Products
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./orders">
                        <i class="material-icons">shopping_cart</i> Orders
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./profile">
                        <i class="material-icons">face</i> Profile
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./logout">
                        <i class="material-icons">logout</i> Logout
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>