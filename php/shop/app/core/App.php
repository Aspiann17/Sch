<?php
// Redirect ke halaman tertentu yang memberi tahu kalau halaman yang dicari tiak ada

class App {
    // Controller Default
    protected $controller = "Shop";

    // Method Default
    protected $method = "index";

    protected $params = [];


    public function __construct() {
        $url = $this->parse_url();

        if (!$url) {
            $url = [$this->controller, $this->method];
        } elseif (count($url) === 1) {
            $url[] = $this->method;
        }

        // Controller
        if (file_exists(__DIR__ . "/../controllers/" . ucfirst($url[0]) . ".php")) {
            $this->controller = ucfirst($url[0]);
            unset($url[0]);
        }

        require_once __DIR__ . "/../controllers/$this->controller.php";
        $this->controller = new $this->controller;


        // Method
        if (method_exists($this->controller, $url[1])) {
            $this->method = $url[1];
            unset($url[1]);
        }

        // Params
        if (!empty($url)) {
            $this->params = array_values($url);
        }


        call_user_func_array([$this->controller, $this->method], $this->params);
    }

    public function parse_url() {
        if (isset($_GET["url"])) {
            // Menghapus / pada akhir URl
            $url = rtrim($_GET["url"], "/");

            // Membersihkan URL
            $url = filter_var($url, FILTER_SANITIZE_URL);

            // Memisah URL
            $url = explode("/", $url);

            return $url;
        }
    }
}