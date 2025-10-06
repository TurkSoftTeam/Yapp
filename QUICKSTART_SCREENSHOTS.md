# Quick Start: Viewing Your Composable Screenshots

## 🎯 The Fastest Way to View Screenshots

After your PR is created or updated, follow these simple steps:

### Step 1: Wait for Build to Complete
- Look for the ✅ green checkmark or ❌ red X next to your commit
- This usually takes 2-5 minutes

### Step 2: Access the Artifacts
Choose one of these methods:

#### Method A: From Your Pull Request (Easiest)
1. Go to your PR page
2. Click the **"Checks"** tab (next to "Files changed")
3. Click on **"Android Build Check"** in the left sidebar
4. Scroll to the bottom of the page
5. Under **"Artifacts"**, click **"composable-screenshots"** to download

#### Method B: From Actions Tab
1. Navigate to: `https://github.com/TurkSoftTeam/Yapp/actions`
2. Click on the latest **"Android Build Check"** run
3. Scroll to **"Artifacts"** section at the bottom
4. Download **"composable-screenshots"**

### Step 3: View the Screenshots
1. Extract the downloaded ZIP file
2. Open the PNG files with any image viewer
3. You'll see screenshots of:
   - `HomeScreen.png` - The main home screen
   - `LoginScreen.png` - The login screen
   - `MainScreen.png` - The main counter screen

## 📁 What's Inside the Artifact?

```
composable-screenshots.zip
├── app/src/test/screenshots/
│   ├── HomeScreen.png
│   ├── LoginScreen.png
│   └── MainScreen.png
└── app/build/outputs/roborazzi/
    └── (additional test artifacts)
```

📖 **Want to know what each screenshot shows?** See [SCREENSHOT_EXAMPLES.md](SCREENSHOT_EXAMPLES.md) for detailed descriptions.

## 🔍 Troubleshooting

**Q: I don't see the "composable-screenshots" artifact**
- Check if the build completed successfully
- Look at the workflow logs for errors in the "Generate screenshots" step
- The artifact is uploaded even if screenshot generation fails (with warnings)

**Q: The artifact is empty or missing screenshots**
- This could mean the screenshot tests didn't run
- Check the test logs in the "Run tests" step
- Verify that Roborazzi dependencies were downloaded correctly

**Q: How long are artifacts kept?**
- GitHub keeps artifacts for 90 days by default
- Download them if you need to keep them longer

## 💡 Pro Tips

- **Compare Before/After**: Download screenshots from main branch and your PR to compare changes
- **Share with Team**: Include screenshot links in PR descriptions for easier review
- **Visual Regression**: Look for unexpected UI changes by comparing screenshots

## 🚀 Next Steps

Want to add screenshots for your own screens? See [SCREENSHOTS.md](SCREENSHOTS.md) for detailed instructions.

---

**Need more help?** Check out the [full documentation](SCREENSHOTS.md) or ask in your PR!
