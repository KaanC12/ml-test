package main

import (
	"fmt"
	"os"
	"os/exec"
	"path/filepath"
	"strings"
)

func main() {
	// go run main.go ml-test play
	args := os.Args

	if len(args) != 5 {
		fmt.Println("Unknown command.")
		fmt.Println("Available commands:")
		fmt.Println("   run   - start the game")
		fmt.Println("   help   - show help")
	}

	if strings.Join(args[3:], " ") == "ml-test play" {
		home, _ := os.UserHomeDir()
		path := filepath.Join(home, "Desktop", "ml-test")
		cmd := exec.Command("java", "-jar", "app.jar")
		cmd.Dir = path

		cmd.Stdout = os.Stdout
		cmd.Stderr = os.Stderr

		err := cmd.Run()

		if err != nil {
			fmt.Println("Error:", err)
		}
	}
}
