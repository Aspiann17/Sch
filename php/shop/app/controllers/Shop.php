<?php

class Shop extends Controller {
    public function index($mode = "") {
        
        $this->view("shop/index", [
            "title" => "Shop",
            "mode" => $mode
        ]);
    }
}