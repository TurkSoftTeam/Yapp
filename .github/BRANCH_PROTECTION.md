# Branch Protection Configuration

This document explains how to configure branch protection rules to ensure that all pull requests must pass the build check before merging.

## Required Status Checks

To enforce that builds must succeed before merging pull requests, follow these steps:

### 1. Navigate to Repository Settings

1. Go to your repository on GitHub
2. Click on **Settings** tab
3. In the left sidebar, click on **Branches**

### 2. Add Branch Protection Rule

1. Click **Add rule** or **Add branch protection rule**
2. In the **Branch name pattern** field, enter: `main`

### 3. Configure Required Status Checks

Enable the following settings:

- ✅ **Require status checks to pass before merging**
  - ✅ **Require branches to be up to date before merging**
  - In the search box under "Status checks that are required", search for and select:
    - `build` (this is the job name from android-ci.yml)

### 4. Additional Recommended Settings

- ✅ **Require a pull request before merging**
  - Optionally: Require approvals (e.g., 1 approval)
- ✅ **Require conversation resolution before merging**
- ✅ **Do not allow bypassing the above settings** (for strict enforcement)

### 5. Save Changes

Click **Create** or **Save changes** at the bottom of the page.

## How It Works

Once configured:

1. **Every commit** to an open PR targeting `main` will trigger the workflow
2. The workflow will:
   - Build the Android project
   - Run all tests
   - Upload build reports if the build fails
3. The PR **cannot be merged** until the `build` check passes
4. If the build fails, developers must fix the issues and push new commits
5. The workflow will automatically re-run on every new commit

## Workflow Triggers

The workflow (`android-ci.yml`) runs on:
- `opened` - When a PR is first opened
- `synchronize` - When new commits are pushed to the PR
- `reopened` - When a previously closed PR is reopened

## Testing the Setup

To verify the configuration:

1. Create a test branch
2. Make a small change
3. Open a PR to `main`
4. Check that the "Android Build Check" workflow runs
5. Verify that the merge button is disabled until the check passes

## Troubleshooting

### Build check not appearing
- Ensure the workflow file is in the `main` branch at `.github/workflows/android-ci.yml`
- Check that the job name in the workflow matches what's selected in branch protection

### Build failing
- Check the workflow logs in the "Actions" tab
- Build reports are automatically uploaded for failed builds
- Download the artifacts to see detailed error messages

## Related Files

- Workflow definition: `.github/workflows/android-ci.yml`
- Build configuration: `build.gradle.kts`
- App build configuration: `app/build.gradle.kts`
